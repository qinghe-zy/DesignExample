<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createReader, deleteReader, fetchReaders, updateReader, type ReaderProfile } from '../../api/library'

const loading = ref(false)
const readers = ref<ReaderProfile[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<ReaderProfile, 'id'>>({ readerNo: '', readerName: '', readerType: 'Student', phone: '', status: 1 })
const rules: FormRules<typeof form> = {
  readerNo: [{ required: true, message: 'Please enter the reader number', trigger: 'blur' }],
  readerName: [{ required: true, message: 'Please enter the reader name', trigger: 'blur' }]
}

async function loadData() { loading.value = true; try { readers.value = await fetchReaders() } finally { loading.value = false } }
function resetForm() { form.readerNo=''; form.readerName=''; form.readerType='Student'; form.phone=''; form.status=1; editingId.value=null }
function openCreate() { dialogMode.value='create'; resetForm(); dialogVisible.value=true }
function openEdit(row: ReaderProfile) { dialogMode.value='edit'; editingId.value=row.id; Object.assign(form, { ...row }); dialogVisible.value=true }
async function submit() { if (!formRef.value) return; await formRef.value.validate(async (valid) => { if (!valid) return; if (dialogMode.value==='create') await createReader(form); else if (editingId.value) await updateReader(editingId.value, form); ElMessage.success(dialogMode.value==='create' ? 'Reader created' : 'Reader updated'); dialogVisible.value=false; await loadData() }) }
async function removeItem(id: number) { await ElMessageBox.confirm('Delete this reader profile?', 'Confirm', { type: 'warning' }); await deleteReader(id); ElMessage.success('Reader deleted'); await loadData() }

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Library Module" title="Reader management" description="Readers connect the library catalog to circulation records. This page gives the seed a concrete operator-facing membership flow.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Reader</el-button></div>
      <el-table :data="readers" v-loading="loading">
        <el-table-column prop="readerNo" label="Reader No" min-width="140" />
        <el-table-column prop="readerName" label="Reader Name" min-width="180" />
        <el-table-column prop="readerType" label="Reader Type" min-width="140" />
        <el-table-column prop="phone" label="Phone" min-width="140" />
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Reader' : 'Edit Reader'" width="min(700px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Reader No" prop="readerNo"><el-input v-model="form.readerNo" /></el-form-item>
          <el-form-item label="Reader Name" prop="readerName"><el-input v-model="form.readerName" /></el-form-item>
          <el-form-item label="Reader Type"><el-select v-model="form.readerType"><el-option label="Student" value="Student" /><el-option label="Teacher" value="Teacher" /></el-select></el-form-item>
          <el-form-item label="Phone"><el-input v-model="form.phone" /></el-form-item>
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
