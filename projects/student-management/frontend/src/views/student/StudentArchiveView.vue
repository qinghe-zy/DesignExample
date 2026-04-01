<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createStudent, deleteStudent, fetchStudents, updateStudent, type StudentProfile } from '../../api/student'

const loading = ref(false)
const students = ref<StudentProfile[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<StudentProfile, 'id'>>({
  studentNo: '',
  studentName: '',
  gender: 'Female',
  className: '',
  majorName: '',
  phone: '',
  status: 1
})

const rules: FormRules<typeof form> = {
  studentNo: [{ required: true, message: 'Please enter the student number', trigger: 'blur' }],
  studentName: [{ required: true, message: 'Please enter the student name', trigger: 'blur' }],
  className: [{ required: true, message: 'Please enter the class name', trigger: 'blur' }],
  majorName: [{ required: true, message: 'Please enter the major name', trigger: 'blur' }]
}

async function loadData() {
  loading.value = true
  try {
    students.value = await fetchStudents()
  } finally {
    loading.value = false
  }
}

function resetForm() {
  form.studentNo = ''
  form.studentName = ''
  form.gender = 'Female'
  form.className = ''
  form.majorName = ''
  form.phone = ''
  form.status = 1
  editingId.value = null
}

function openCreate() {
  dialogMode.value = 'create'
  resetForm()
  dialogVisible.value = true
}

function openEdit(row: StudentProfile) {
  dialogMode.value = 'edit'
  editingId.value = row.id
  form.studentNo = row.studentNo
  form.studentName = row.studentName
  form.gender = row.gender
  form.className = row.className
  form.majorName = row.majorName
  form.phone = row.phone
  form.status = row.status
  dialogVisible.value = true
}

async function submit() {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (!valid) return
    if (dialogMode.value === 'create') {
      await createStudent(form)
      ElMessage.success('Student created')
    } else if (editingId.value) {
      await updateStudent(editingId.value, form)
      ElMessage.success('Student updated')
    }
    dialogVisible.value = false
    await loadData()
  })
}

async function removeItem(id: number) {
  await ElMessageBox.confirm('Delete this student profile?', 'Confirm', { type: 'warning' })
  await deleteStudent(id)
  ElMessage.success('Student deleted')
  await loadData()
}

onMounted(loadData)
</script>

<template>
  <AppShellSection
    eyebrow="Student Module"
    title="Student archive"
    description="The student archive is the anchor module for this seed. It keeps the shared admin baseline while introducing real business records for academic projects."
  >
    <section class="panel-card section-card">
      <div class="toolbar">
        <el-button type="primary" @click="openCreate">New Student</el-button>
      </div>
      <el-table :data="students" v-loading="loading">
        <el-table-column prop="studentNo" label="Student No" min-width="140" />
        <el-table-column prop="studentName" label="Name" min-width="140" />
        <el-table-column prop="gender" label="Gender" min-width="100" />
        <el-table-column prop="className" label="Class" min-width="180" />
        <el-table-column prop="majorName" label="Major" min-width="180" />
        <el-table-column prop="phone" label="Phone" min-width="140" />
        <el-table-column label="Actions" min-width="160" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="openEdit(row)">Edit</el-button>
            <el-button link type="danger" @click="removeItem(row.id)">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </section>

    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Student' : 'Edit Student'" width="min(720px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <div class="grid-two">
          <el-form-item label="Student No" prop="studentNo">
            <el-input v-model="form.studentNo" />
          </el-form-item>
          <el-form-item label="Student Name" prop="studentName">
            <el-input v-model="form.studentName" />
          </el-form-item>
          <el-form-item label="Gender">
            <el-select v-model="form.gender">
              <el-option label="Female" value="Female" />
              <el-option label="Male" value="Male" />
            </el-select>
          </el-form-item>
          <el-form-item label="Phone">
            <el-input v-model="form.phone" />
          </el-form-item>
          <el-form-item label="Class Name" prop="className">
            <el-input v-model="form.className" />
          </el-form-item>
          <el-form-item label="Major Name" prop="majorName">
            <el-input v-model="form.majorName" />
          </el-form-item>
        </div>
        <el-form-item label="Status">
          <el-select v-model="form.status">
            <el-option :value="1" label="Active" />
            <el-option :value="0" label="Suspended" />
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
