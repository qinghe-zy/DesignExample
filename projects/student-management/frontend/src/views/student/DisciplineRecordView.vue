<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import {
  createDisciplineRecord,
  deleteDisciplineRecord,
  fetchDisciplineRecords,
  updateDisciplineRecord,
  type DisciplineRecord
} from '../../api/student'

const loading = ref(false)
const records = ref<DisciplineRecord[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<DisciplineRecord, 'id'>>({
  studentNo: '',
  studentName: '',
  recordType: 'Leave',
  description: '',
  recordDate: '',
  status: 1
})

const rules: FormRules<typeof form> = {
  studentNo: [{ required: true, message: 'Please enter the student number', trigger: 'blur' }],
  studentName: [{ required: true, message: 'Please enter the student name', trigger: 'blur' }],
  description: [{ required: true, message: 'Please enter the description', trigger: 'blur' }],
  recordDate: [{ required: true, message: 'Please select the record date', trigger: 'change' }]
}

async function loadData() {
  loading.value = true
  try {
    records.value = await fetchDisciplineRecords()
  } finally {
    loading.value = false
  }
}

function resetForm() {
  form.studentNo = ''
  form.studentName = ''
  form.recordType = 'Leave'
  form.description = ''
  form.recordDate = ''
  form.status = 1
  editingId.value = null
}

function openCreate() {
  dialogMode.value = 'create'
  resetForm()
  dialogVisible.value = true
}

function openEdit(row: DisciplineRecord) {
  dialogMode.value = 'edit'
  editingId.value = row.id
  form.studentNo = row.studentNo
  form.studentName = row.studentName
  form.recordType = row.recordType
  form.description = row.description
  form.recordDate = row.recordDate
  form.status = row.status
  dialogVisible.value = true
}

async function submit() {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (!valid) return
    if (dialogMode.value === 'create') {
      await createDisciplineRecord(form)
      ElMessage.success('Record created')
    } else if (editingId.value) {
      await updateDisciplineRecord(editingId.value, form)
      ElMessage.success('Record updated')
    }
    dialogVisible.value = false
    await loadData()
  })
}

async function removeItem(id: number) {
  await ElMessageBox.confirm('Delete this record?', 'Confirm', { type: 'warning' })
  await deleteDisciplineRecord(id)
  ElMessage.success('Record deleted')
  await loadData()
}

onMounted(loadData)
</script>

<template>
  <AppShellSection
    eyebrow="Student Module"
    title="Leave and discipline follow-up"
    description="This module represents the kind of student-life records that often appear alongside archive and score management in graduation-project systems."
  >
    <section class="panel-card section-card">
      <div class="toolbar">
        <el-button type="primary" @click="openCreate">New Record</el-button>
      </div>
      <el-table :data="records" v-loading="loading">
        <el-table-column prop="studentNo" label="Student No" min-width="140" />
        <el-table-column prop="studentName" label="Name" min-width="140" />
        <el-table-column prop="recordType" label="Type" min-width="140" />
        <el-table-column prop="recordDate" label="Date" min-width="140" />
        <el-table-column prop="description" label="Description" min-width="260" show-overflow-tooltip />
        <el-table-column label="Actions" min-width="160" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="openEdit(row)">Edit</el-button>
            <el-button link type="danger" @click="removeItem(row.id)">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </section>

    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Record' : 'Edit Record'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Student No" prop="studentNo">
            <el-input v-model="form.studentNo" />
          </el-form-item>
          <el-form-item label="Student Name" prop="studentName">
            <el-input v-model="form.studentName" />
          </el-form-item>
          <el-form-item label="Record Type">
            <el-select v-model="form.recordType">
              <el-option label="Leave" value="Leave" />
              <el-option label="Discipline" value="Discipline" />
              <el-option label="Merit" value="Merit" />
            </el-select>
          </el-form-item>
          <el-form-item label="Record Date" prop="recordDate">
            <el-date-picker v-model="form.recordDate" type="date" value-format="YYYY-MM-DD" />
          </el-form-item>
        </div>
        <el-form-item label="Description" prop="description">
          <el-input v-model="form.description" type="textarea" :rows="4" />
        </el-form-item>
        <el-form-item label="Status">
          <el-select v-model="form.status">
            <el-option :value="1" label="Active" />
            <el-option :value="0" label="Archived" />
          </el-select>
        </el-form-item>
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
