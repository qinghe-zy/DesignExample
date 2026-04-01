<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createPaper, deletePaper, fetchPapers, updatePaper, type ExamPaper } from '../../api/exam'

const loading = ref(false)
const papers = ref<ExamPaper[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<ExamPaper, 'id'>>({ paperName: '', courseName: '', durationMinutes: 90, totalScore: 100, publishStatus: 0 })
const rules: FormRules<typeof form> = { paperName: [{ required: true, message: 'Please enter the paper name', trigger: 'blur' }], courseName: [{ required: true, message: 'Please enter the course name', trigger: 'blur' }] }

async function loadData() { loading.value = true; try { papers.value = await fetchPapers() } finally { loading.value = false } }
function resetForm() { form.paperName=''; form.courseName=''; form.durationMinutes=90; form.totalScore=100; form.publishStatus=0; editingId.value=null }
function openCreate() { dialogMode.value='create'; resetForm(); dialogVisible.value=true }
function openEdit(row: ExamPaper) { dialogMode.value='edit'; editingId.value=row.id; Object.assign(form, { ...row }); dialogVisible.value=true }
async function submit() { if (!formRef.value) return; await formRef.value.validate(async (valid)=>{ if(!valid) return; if(dialogMode.value==='create') await createPaper(form); else if(editingId.value) await updatePaper(editingId.value, form); ElMessage.success(dialogMode.value==='create' ? 'Paper created' : 'Paper updated'); dialogVisible.value=false; await loadData() }) }
async function removeItem(id:number){ await ElMessageBox.confirm('Delete this paper?', 'Confirm', { type: 'warning' }); await deletePaper(id); ElMessage.success('Paper deleted'); await loadData() }

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Exam Module" title="Exam paper management" description="Papers turn the question bank into deliverable exams. This page provides the seed with a concrete planning and publishing layer.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Paper</el-button></div>
      <el-table :data="papers" v-loading="loading">
        <el-table-column prop="paperName" label="Paper Name" min-width="220" />
        <el-table-column prop="courseName" label="Course" min-width="180" />
        <el-table-column prop="durationMinutes" label="Duration" min-width="100" />
        <el-table-column prop="totalScore" label="Total Score" min-width="100" />
        <el-table-column label="Status" min-width="120"><template #default="{ row }"><el-tag :type="row.publishStatus === 1 ? 'success' : 'info'">{{ row.publishStatus === 1 ? 'Published' : 'Draft' }}</el-tag></template></el-table-column>
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Paper' : 'Edit Paper'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Paper Name" prop="paperName"><el-input v-model="form.paperName" /></el-form-item>
          <el-form-item label="Course Name" prop="courseName"><el-input v-model="form.courseName" /></el-form-item>
          <el-form-item label="Duration Minutes"><el-input-number v-model="form.durationMinutes" :min="1" /></el-form-item>
          <el-form-item label="Total Score"><el-input-number v-model="form.totalScore" :min="1" /></el-form-item>
          <el-form-item label="Publish Status"><el-select v-model="form.publishStatus"><el-option :value="0" label="Draft" /><el-option :value="1" label="Published" /></el-select></el-form-item>
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
