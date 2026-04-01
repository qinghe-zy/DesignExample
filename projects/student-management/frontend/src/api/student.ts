import http from './http'

export interface AcademicClass {
  id: number
  className: string
  majorName: string
  gradeLevel: string
  counselor: string
  status: number
}

export interface StudentProfile {
  id: number
  studentNo: string
  studentName: string
  gender: string
  className: string
  majorName: string
  phone: string
  status: number
}

export interface ScoreRecord {
  id: number
  studentNo: string
  studentName: string
  courseName: string
  termName: string
  scoreValue: number
  status: number
}

export interface DisciplineRecord {
  id: number
  studentNo: string
  studentName: string
  recordType: string
  description: string
  recordDate: string
  status: number
}

export function fetchClasses() {
  return http.get<never, AcademicClass[]>('/api/student/classes')
}

export function createClass(payload: Omit<AcademicClass, 'id'>) {
  return http.post<never, AcademicClass>('/api/student/classes', payload)
}

export function updateClass(id: number, payload: Omit<AcademicClass, 'id'>) {
  return http.put<never, AcademicClass>(`/api/student/classes/${id}`, payload)
}

export function deleteClass(id: number) {
  return http.delete(`/api/student/classes/${id}`)
}

export function fetchStudents() {
  return http.get<never, StudentProfile[]>('/api/student/profiles')
}

export function createStudent(payload: Omit<StudentProfile, 'id'>) {
  return http.post<never, StudentProfile>('/api/student/profiles', payload)
}

export function updateStudent(id: number, payload: Omit<StudentProfile, 'id'>) {
  return http.put<never, StudentProfile>(`/api/student/profiles/${id}`, payload)
}

export function deleteStudent(id: number) {
  return http.delete(`/api/student/profiles/${id}`)
}

export function fetchScores() {
  return http.get<never, ScoreRecord[]>('/api/student/scores')
}

export function createScore(payload: Omit<ScoreRecord, 'id'>) {
  return http.post<never, ScoreRecord>('/api/student/scores', payload)
}

export function updateScore(id: number, payload: Omit<ScoreRecord, 'id'>) {
  return http.put<never, ScoreRecord>(`/api/student/scores/${id}`, payload)
}

export function deleteScore(id: number) {
  return http.delete(`/api/student/scores/${id}`)
}

export function fetchDisciplineRecords() {
  return http.get<never, DisciplineRecord[]>('/api/student/discipline-records')
}

export function createDisciplineRecord(payload: Omit<DisciplineRecord, 'id'>) {
  return http.post<never, DisciplineRecord>('/api/student/discipline-records', payload)
}

export function updateDisciplineRecord(id: number, payload: Omit<DisciplineRecord, 'id'>) {
  return http.put<never, DisciplineRecord>(`/api/student/discipline-records/${id}`, payload)
}

export function deleteDisciplineRecord(id: number) {
  return http.delete(`/api/student/discipline-records/${id}`)
}
