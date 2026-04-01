<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createExamRecord, deleteExamRecord, fetchExamRecords, updateExamRecord, type ExamRecord } from '../../api/exam'

const loading = ref(false)
const records = ref<ExamRecord[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<ExamRecord, 'id'>>({ studentName: '', paperName: '', attemptDate: '', scoreValue: 0, status: 1 })
const rules: FormRules<typeof form> = { studentName: [{ required: true, message: 'Please enter the student name', trigger: 'blur' }], paperName: [{ required: true, message: 'Please enter the paper name', trigger: 'blur' }] }

async function loadData() { loading.value = true; try { records.value = await fetchExamRecords() } finally { loading.value = false } }
function resetForm() { form.studentName=''; form.paperName=''; form.attemptDate=''; form.scoreValue=0; form.status=1; editingId.value=null }
function openCreate() { dialogMode.value='create'; resetForm(); dialogVisible.value=true }
function openEdit(row: ExamRecord) { dialogMode.value='edit'; editingId.value=row.id; Object.assign(form, { ...row }); dialogVisible.value=true }
async function submit() { if (!formRef.value) return; await formRef.value.validate(async (valid)=>{ if(!valid) return; if(dialogMode.value==='create') await createExamRecord(form); else if(editingId.value) await updateExamRecord(editingId.value, form); ElMessage.success(dialogMode.value==='create' ? 'Exam record created' : 'Exam record updated'); dialogVisible.value=false; await loadData() }) }
async function removeItem(id:number){ await ElMessageBox.confirm('Delete this exam record?', 'Confirm', { type: 'warning' }); await deleteExamRecord(id); ElMessage.success('Exam record deleted'); await loadData() }

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Exam Module" title="Exam records and results" description="Exam records represent the outcome side of the exam seed, connecting paper planning to student-facing results and scoring visibility.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Record</el-button></div>
      <el-table :data="records" v-loading="loading">
        <el-table-column prop="studentName" label="Student" min-width="160" />
        <el-table-column prop="paperName" label="Paper" min-width="220" />
        <el-table-column prop="attemptDate" label="Attempt Date" min-width="140" />
        <el-table-column prop="scoreValue" label="Score" min-width="100" />
        <el-table-column label="Status" min-width="120"><template #default="{ row }"><el-tag :type="row.status === 1 ? 'success' : 'info'">{{ row.status === 1 ? 'Published' : 'Draft' }}</el-tag></template></el-table-column>
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Exam Record' : 'Edit Exam Record'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Student Name" prop="studentName"><el-input v-model="form.studentName" /></el-form-item>
          <el-form-item label="Paper Name" prop="paperName"><el-input v-model="form.paperName" /></el-form-item>
          <el-form-item label="Attempt Date"><el-date-picker v-model="form.attemptDate" type="date" value-format="YYYY-MM-DD" /></el-form-item>
          <el-form-item label="Score"><el-input-number v-model="form.scoreValue" :min="0" :max="100" :precision="1" /></el-form-item>
          <el-form-item label="Status"><el-select v-model="form.status"><el-option :value="1" label="Published" /><el-option :value="0" label="Draft" /></el-select></el-form-item>
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
