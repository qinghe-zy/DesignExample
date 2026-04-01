<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createQuestion, deleteQuestion, fetchQuestions, updateQuestion, type QuestionBank } from '../../api/exam'

const loading = ref(false)
const questions = ref<QuestionBank[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<QuestionBank, 'id'>>({ subject: '', questionType: 'Single Choice', difficultyLevel: 'Medium', stem: '', answerKey: '', status: 1 })
const rules: FormRules<typeof form> = { subject: [{ required: true, message: 'Please enter the subject', trigger: 'blur' }], stem: [{ required: true, message: 'Please enter the question stem', trigger: 'blur' }] }

async function loadData() { loading.value = true; try { questions.value = await fetchQuestions() } finally { loading.value = false } }
function resetForm() { form.subject=''; form.questionType='Single Choice'; form.difficultyLevel='Medium'; form.stem=''; form.answerKey=''; form.status=1; editingId.value=null }
function openCreate() { dialogMode.value='create'; resetForm(); dialogVisible.value=true }
function openEdit(row: QuestionBank) { dialogMode.value='edit'; editingId.value=row.id; Object.assign(form, { ...row }); dialogVisible.value=true }
async function submit() { if (!formRef.value) return; await formRef.value.validate(async (valid)=>{ if(!valid) return; if(dialogMode.value==='create') await createQuestion(form); else if(editingId.value) await updateQuestion(editingId.value, form); ElMessage.success(dialogMode.value==='create' ? 'Question created' : 'Question updated'); dialogVisible.value=false; await loadData() }) }
async function removeItem(id:number){ await ElMessageBox.confirm('Delete this question?', 'Confirm', { type: 'warning' }); await deleteQuestion(id); ElMessage.success('Question deleted'); await loadData() }

onMounted(loadData)
</script>

<template>
  <AppShellSection eyebrow="Exam Module" title="Question bank" description="The question bank is the content backbone of the exam seed. It makes the project more than a renamed admin shell by introducing real exam assets.">
    <section class="panel-card section-card">
      <div class="toolbar"><el-button type="primary" @click="openCreate">New Question</el-button></div>
      <el-table :data="questions" v-loading="loading">
        <el-table-column prop="subject" label="Subject" min-width="120" />
        <el-table-column prop="questionType" label="Type" min-width="140" />
        <el-table-column prop="difficultyLevel" label="Difficulty" min-width="120" />
        <el-table-column prop="stem" label="Question Stem" min-width="280" show-overflow-tooltip />
        <el-table-column label="Actions" min-width="160" fixed="right"><template #default="{ row }"><el-button link type="primary" @click="openEdit(row)">Edit</el-button><el-button link type="danger" @click="removeItem(row.id)">Delete</el-button></template></el-table-column>
      </el-table>
    </section>
    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Question' : 'Edit Question'" width="min(760px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Subject" prop="subject"><el-input v-model="form.subject" /></el-form-item>
          <el-form-item label="Question Type"><el-select v-model="form.questionType"><el-option label="Single Choice" value="Single Choice" /><el-option label="Multiple Choice" value="Multiple Choice" /><el-option label="Short Answer" value="Short Answer" /></el-select></el-form-item>
          <el-form-item label="Difficulty"><el-select v-model="form.difficultyLevel"><el-option label="Easy" value="Easy" /><el-option label="Medium" value="Medium" /><el-option label="Hard" value="Hard" /></el-select></el-form-item>
          <el-form-item label="Status"><el-select v-model="form.status"><el-option :value="1" label="Active" /><el-option :value="0" label="Draft" /></el-select></el-form-item>
        </div>
        <el-form-item label="Question Stem" prop="stem"><el-input v-model="form.stem" type="textarea" :rows="4" /></el-form-item>
        <el-form-item label="Answer Key"><el-input v-model="form.answerKey" type="textarea" :rows="3" /></el-form-item>
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
