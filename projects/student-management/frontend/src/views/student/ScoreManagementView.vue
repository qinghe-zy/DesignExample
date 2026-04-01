<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createScore, deleteScore, fetchScores, updateScore, type ScoreRecord } from '../../api/student'

const loading = ref(false)
const scores = ref<ScoreRecord[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<ScoreRecord, 'id'>>({
  studentNo: '',
  studentName: '',
  courseName: '',
  termName: '',
  scoreValue: 0,
  status: 1
})

const rules: FormRules<typeof form> = {
  studentNo: [{ required: true, message: 'Please enter the student number', trigger: 'blur' }],
  studentName: [{ required: true, message: 'Please enter the student name', trigger: 'blur' }],
  courseName: [{ required: true, message: 'Please enter the course name', trigger: 'blur' }],
  termName: [{ required: true, message: 'Please enter the term', trigger: 'blur' }]
}

async function loadData() {
  loading.value = true
  try {
    scores.value = await fetchScores()
  } finally {
    loading.value = false
  }
}

function resetForm() {
  form.studentNo = ''
  form.studentName = ''
  form.courseName = ''
  form.termName = ''
  form.scoreValue = 0
  form.status = 1
  editingId.value = null
}

function openCreate() {
  dialogMode.value = 'create'
  resetForm()
  dialogVisible.value = true
}

function openEdit(row: ScoreRecord) {
  dialogMode.value = 'edit'
  editingId.value = row.id
  form.studentNo = row.studentNo
  form.studentName = row.studentName
  form.courseName = row.courseName
  form.termName = row.termName
  form.scoreValue = row.scoreValue
  form.status = row.status
  dialogVisible.value = true
}

async function submit() {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (!valid) return
    if (dialogMode.value === 'create') {
      await createScore(form)
      ElMessage.success('Score created')
    } else if (editingId.value) {
      await updateScore(editingId.value, form)
      ElMessage.success('Score updated')
    }
    dialogVisible.value = false
    await loadData()
  })
}

async function removeItem(id: number) {
  await ElMessageBox.confirm('Delete this score record?', 'Confirm', { type: 'warning' })
  await deleteScore(id)
  ElMessage.success('Score deleted')
  await loadData()
}

onMounted(loadData)
</script>

<template>
  <AppShellSection
    eyebrow="Student Module"
    title="Score and grade management"
    description="Scores turn the student seed from a simple archive into an academic management system. The page uses the same reusable admin interaction model while tracking course outcomes."
  >
    <section class="panel-card section-card">
      <div class="toolbar">
        <el-button type="primary" @click="openCreate">New Score</el-button>
      </div>
      <el-table :data="scores" v-loading="loading">
        <el-table-column prop="studentNo" label="Student No" min-width="140" />
        <el-table-column prop="studentName" label="Name" min-width="140" />
        <el-table-column prop="courseName" label="Course" min-width="180" />
        <el-table-column prop="termName" label="Term" min-width="140" />
        <el-table-column prop="scoreValue" label="Score" min-width="100" />
        <el-table-column label="Status" min-width="120">
          <template #default="{ row }">
            <el-tag :type="row.status === 1 ? 'success' : 'warning'">{{ row.status === 1 ? 'Published' : 'Draft' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="Actions" min-width="160" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="openEdit(row)">Edit</el-button>
            <el-button link type="danger" @click="removeItem(row.id)">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </section>

    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Score' : 'Edit Score'" width="min(700px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Student No" prop="studentNo">
            <el-input v-model="form.studentNo" />
          </el-form-item>
          <el-form-item label="Student Name" prop="studentName">
            <el-input v-model="form.studentName" />
          </el-form-item>
          <el-form-item label="Course Name" prop="courseName">
            <el-input v-model="form.courseName" />
          </el-form-item>
          <el-form-item label="Term" prop="termName">
            <el-input v-model="form.termName" />
          </el-form-item>
          <el-form-item label="Score">
            <el-input-number v-model="form.scoreValue" :min="0" :max="100" :precision="2" />
          </el-form-item>
          <el-form-item label="Status">
            <el-select v-model="form.status">
              <el-option :value="1" label="Published" />
              <el-option :value="0" label="Draft" />
            </el-select>
          </el-form-item>
        </div>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="submit">Save</el-button>
      </template>
    </el-dialog>
  </AppShellSection>
</template>

<style scoped>
.section-card { padding: 1rem; }
.toolbar { display: flex; justify-content: flex-end; margin-bottom: 0.85rem; }
.grid-two { display: grid; grid-template-columns: repeat(2, minmax(0, 1fr)); gap: 0.8rem; }
@media (max-width: 760px) { .grid-two { grid-template-columns: 1fr; } }
</style>
