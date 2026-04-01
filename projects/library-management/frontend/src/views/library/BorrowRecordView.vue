<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createBorrowRecord, deleteBorrowRecord, fetchBorrowRecords, updateBorrowRecord, type BorrowRecord } from '../../api/library'

const loading = ref(false)
const records = ref<BorrowRecord[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<BorrowRecord, 'id'>>({ readerNo: '', readerName: '', bookTitle: '', borrowDate: '', dueDate: '', returnDate: '', status: 0 })
const rules: FormRules<typeof form> = {
  readerNo: [{ required: true, message: 'Please enter the reader number', trigger: 'blur' }],
  readerName: [{ required: true, message: 'Please enter the reader name', trigger: 'blur' }],
  bookTitle: [{ required: true, message: 'Please enter the book title', trigger: 'blur' }],
  borrowDate: [{ required: true, message: 'Please select the borrow date', trigger: 'change' }],
  dueDate: [{ required: true, message: 'Please select the due date', trigger: 'change' }]
}

async function loadData() { loading.value = true; try { records.value = await fetchBorrowRecords() } finally { loading.value = false } }
function resetForm() { form.readerNo=''; form.readerName=''; form.bookTitle=''; form.borrowDate=''; form.dueDate=''; form.returnDate=''; form.status=0; editingId.value=null }
function openCreate() { dialogMode.value='create'; resetForm(); dialogVisible.value=true }
function openEdit(row: BorrowRecord) { dialogMode.value='edit'; editingId.value=row.id; Object.assign(form, { ...row, returnDate: row.returnDate || '' }); dialogVisible.value=true }
async function submit() { if (!formRef.value) return; await formRef.value.validate(async (valid) => { if (!valid) return; const payload = { ...form, returnDate: form.returnDate || null }; if (dialogMode.value==='create') await createBorrowRecord(payload as any); else if (editingId.value) await updateBorrowRecord(editingId.value, payload as any); ElMessage.success(dialogMode.value==='create' ? 'Borrow record created' : 'Borrow record updated'); dialogVisible.value=false; await loadData() }) }
async function removeItem(id: number) { await ElMessageBox.confirm('Delete this borrow record?', 'Confirm', { type: 'warning' }); await deleteBorrowRecord(id); ElMessage.success('Borrow record deleted'); await loadData() }

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Library Module" title="Borrow and return flow" description="Borrow records connect catalog and readers into a real circulation workflow, giving the library seed a meaningful operational core.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Borrow Record</el-button></div>
      <el-table :data="records" v-loading="loading">
        <el-table-column prop="readerName" label="Reader" min-width="160" />
        <el-table-column prop="bookTitle" label="Book" min-width="200" />
        <el-table-column prop="borrowDate" label="Borrow Date" min-width="140" />
        <el-table-column prop="dueDate" label="Due Date" min-width="140" />
        <el-table-column prop="returnDate" label="Return Date" min-width="140" />
        <el-table-column label="Status" min-width="120"><template #default="{ row }"><el-tag :type="row.status === 1 ? 'success' : row.status === 2 ? 'danger' : 'warning'">{{ row.status === 1 ? 'Returned' : row.status === 2 ? 'Overdue' : 'Borrowed' }}</el-tag></template></el-table-column>
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Borrow Record' : 'Edit Borrow Record'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Reader No" prop="readerNo"><el-input v-model="form.readerNo" /></el-form-item>
          <el-form-item label="Reader Name" prop="readerName"><el-input v-model="form.readerName" /></el-form-item>
          <el-form-item label="Book Title" prop="bookTitle"><el-input v-model="form.bookTitle" /></el-form-item>
          <el-form-item label="Borrow Date" prop="borrowDate"><el-date-picker v-model="form.borrowDate" type="date" value-format="YYYY-MM-DD" /></el-form-item>
          <el-form-item label="Due Date" prop="dueDate"><el-date-picker v-model="form.dueDate" type="date" value-format="YYYY-MM-DD" /></el-form-item>
          <el-form-item label="Return Date"><el-date-picker v-model="form.returnDate" type="date" value-format="YYYY-MM-DD" /></el-form-item>
          <el-form-item label="Status"><el-select v-model="form.status"><el-option :value="0" label="Borrowed" /><el-option :value="1" label="Returned" /><el-option :value="2" label="Overdue" /></el-select></el-form-item>
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
