<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance, type FormRules } from 'element-plus'

import AppShellSection from '../../components/AppShellSection.vue'
import { createClass, deleteClass, fetchClasses, updateClass, type AcademicClass } from '../../api/student'

const loading = ref(false)
const classes = ref<AcademicClass[]>([])
const dialogVisible = ref(false)
const dialogMode = ref<'create' | 'edit'>('create')
const editingId = ref<number | null>(null)
const formRef = ref<FormInstance>()

const form = reactive<Omit<AcademicClass, 'id'>>({
  className: '',
  majorName: '',
  gradeLevel: '',
  counselor: '',
  status: 1
})

const rules: FormRules<typeof form> = {
  className: [{ required: true, message: 'Please enter the class name', trigger: 'blur' }],
  majorName: [{ required: true, message: 'Please enter the major name', trigger: 'blur' }],
  gradeLevel: [{ required: true, message: 'Please enter the grade level', trigger: 'blur' }],
  counselor: [{ required: true, message: 'Please enter the counselor', trigger: 'blur' }]
}

async function loadData() {
  loading.value = true
  try {
    classes.value = await fetchClasses()
  } finally {
    loading.value = false
  }
}

function resetForm() {
  form.className = ''
  form.majorName = ''
  form.gradeLevel = ''
  form.counselor = ''
  form.status = 1
  editingId.value = null
}

function openCreate() {
  dialogMode.value = 'create'
  resetForm()
  dialogVisible.value = true
}

function openEdit(row: AcademicClass) {
  dialogMode.value = 'edit'
  editingId.value = row.id
  form.className = row.className
  form.majorName = row.majorName
  form.gradeLevel = row.gradeLevel
  form.counselor = row.counselor
  form.status = row.status
  dialogVisible.value = true
}

async function submit() {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (!valid) return
    if (dialogMode.value === 'create') {
      await createClass(form)
      ElMessage.success('Class created')
    } else if (editingId.value) {
      await updateClass(editingId.value, form)
      ElMessage.success('Class updated')
    }
    dialogVisible.value = false
    await loadData()
  })
}

async function removeItem(id: number) {
  await ElMessageBox.confirm('Delete this class record?', 'Confirm', { type: 'warning' })
  await deleteClass(id)
  ElMessage.success('Class deleted')
  await loadData()
}

onMounted(loadData)
</script>

<template>
  <AppShellSection
    eyebrow="Student Module"
    title="Class and major coordination"
    description="Classes are the organizational spine of the student-management seed. This page keeps the baseline admin rhythm while giving the project a real academic structure."
  >
    <section class="panel-card section-card">
      <div class="toolbar">
        <el-button type="primary" @click="openCreate">New Class</el-button>
      </div>
      <el-table :data="classes" v-loading="loading">
        <el-table-column prop="className" label="Class" min-width="200" />
        <el-table-column prop="majorName" label="Major" min-width="180" />
        <el-table-column prop="gradeLevel" label="Grade" min-width="120" />
        <el-table-column prop="counselor" label="Counselor" min-width="160" />
        <el-table-column label="Status" min-width="120">
          <template #default="{ row }">
            <el-tag :type="row.status === 1 ? 'success' : 'info'">{{ row.status === 1 ? 'Active' : 'Closed' }}</el-tag>
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

    <el-dialog v-model="dialogVisible" :title="dialogMode === 'create' ? 'Create Class' : 'Edit Class'" width="min(640px, 92vw)" @closed="resetForm">
      <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
        <el-form-item label="Class Name" prop="className">
          <el-input v-model="form.className" />
        </el-form-item>
        <el-form-item label="Major Name" prop="majorName">
          <el-input v-model="form.majorName" />
        </el-form-item>
        <el-form-item label="Grade Level" prop="gradeLevel">
          <el-input v-model="form.gradeLevel" />
        </el-form-item>
        <el-form-item label="Counselor" prop="counselor">
          <el-input v-model="form.counselor" />
        </el-form-item>
        <el-form-item label="Status">
          <el-select v-model="form.status">
            <el-option :value="1" label="Active" />
            <el-option :value="0" label="Closed" />
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
</style>
