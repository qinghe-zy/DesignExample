<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createBook, deleteBook, fetchBooks, updateBook, type BookCatalog } from '../../api/library'

const loading = ref(false)
const books = ref<BookCatalog[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<BookCatalog, 'id'>>({
  bookCode: '',
  title: '',
  category: '',
  author: '',
  publisher: '',
  stock: 0,
  status: 1
})

const rules: FormRules<typeof form> = {
  bookCode: [{ required: true, message: 'Please enter the book code', trigger: 'blur' }],
  title: [{ required: true, message: 'Please enter the title', trigger: 'blur' }],
  category: [{ required: true, message: 'Please enter the category', trigger: 'blur' }]
}

async function loadData() {
  loading.value = true
  try { books.value = await fetchBooks() } finally { loading.value = false }
}

function resetForm() {
  form.bookCode = ''
  form.title = ''
  form.category = ''
  form.author = ''
  form.publisher = ''
  form.stock = 0
  form.status = 1
  editingId.value = null
}

function openCreate() { dialogMode.value = 'create'; resetForm(); dialogVisible.value = true }
function openEdit(row: BookCatalog) { dialogMode.value = 'edit'; editingId.value = row.id; Object.assign(form, { ...row }); dialogVisible.value = true }
async function submit() {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (!valid) return
    if (dialogMode.value === 'create') await createBook(form)
    else if (editingId.value) await updateBook(editingId.value, form)
    ElMessage.success(dialogMode.value === 'create' ? 'Book created' : 'Book updated')
    dialogVisible.value = false
    await loadData()
  })
}
async function removeItem(id: number) {
  await ElMessageBox.confirm('Delete this book record?', 'Confirm', { type: 'warning' })
  await deleteBook(id)
  ElMessage.success('Book deleted')
  await loadData()
}

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Library Module" title="Book catalog" description="The catalog is the anchor module for the library seed. It keeps the shared admin interaction model while introducing concrete inventory records.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Book</el-button></div>
      <el-table :data="books" v-loading="loading">
        <el-table-column prop="bookCode" label="Book Code" min-width="120" />
        <el-table-column prop="title" label="Title" min-width="200" />
        <el-table-column prop="category" label="Category" min-width="160" />
        <el-table-column prop="author" label="Author" min-width="140" />
        <el-table-column prop="publisher" label="Publisher" min-width="180" />
        <el-table-column prop="stock" label="Stock" min-width="100" />
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Book' : 'Edit Book'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Book Code" prop="bookCode"><el-input v-model="form.bookCode" /></el-form-item>
          <el-form-item label="Title" prop="title"><el-input v-model="form.title" /></el-form-item>
          <el-form-item label="Category" prop="category"><el-input v-model="form.category" /></el-form-item>
          <el-form-item label="Author"><el-input v-model="form.author" /></el-form-item>
          <el-form-item label="Publisher"><el-input v-model="form.publisher" /></el-form-item>
          <el-form-item label="Stock"><el-input-number v-model="form.stock" :min="0" /></el-form-item>
        </div>
      </el-form>
      <template #footer><el-button @click="dialogVisible = false">Cancel</el-button><el-button type="primary" @click="submit">Save</el-button></template>
    </el-dialog>
  </AppShellSection>
</template>

<style scoped>
.section-card { padding: 1rem; }
.toolbar { display: flex; justify-content: flex-end; margin-bottom: 0.85rem; }
.grid-two { display: grid; grid-template-columns: repeat(2, minmax(0, 1fr)); gap: 0.8rem; }
@media (max-width: 760px) { .grid-two { grid-template-columns: 1fr; } }
</style>
