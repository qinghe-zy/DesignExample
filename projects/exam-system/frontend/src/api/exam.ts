import http from './http'

export interface QuestionBank {
  id: number
  subject: string
  questionType: string
  difficultyLevel: string
  stem: string
  answerKey: string
  status: number
}

export interface ExamPaper {
  id: number
  paperName: string
  courseName: string
  durationMinutes: number
  totalScore: number
  publishStatus: number
}

export interface ExamRecord {
  id: number
  studentName: string
  paperName: string
  attemptDate: string
  scoreValue: number
  status: number
}

export function fetchQuestions() {
  return http.get<never, QuestionBank[]>('/api/exam/questions')
}

export function createQuestion(payload: Omit<QuestionBank, 'id'>) {
  return http.post<never, QuestionBank>('/api/exam/questions', payload)
}

export function updateQuestion(id: number, payload: Omit<QuestionBank, 'id'>) {
  return http.put<never, QuestionBank>(`/api/exam/questions/${id}`, payload)
}

export function deleteQuestion(id: number) {
  return http.delete(`/api/exam/questions/${id}`)
}

export function fetchPapers() {
  return http.get<never, ExamPaper[]>('/api/exam/papers')
}

export function createPaper(payload: Omit<ExamPaper, 'id'>) {
  return http.post<never, ExamPaper>('/api/exam/papers', payload)
}

export function updatePaper(id: number, payload: Omit<ExamPaper, 'id'>) {
  return http.put<never, ExamPaper>(`/api/exam/papers/${id}`, payload)
}

export function deletePaper(id: number) {
  return http.delete(`/api/exam/papers/${id}`)
}

export function fetchExamRecords() {
  return http.get<never, ExamRecord[]>('/api/exam/records')
}

export function createExamRecord(payload: Omit<ExamRecord, 'id'>) {
  return http.post<never, ExamRecord>('/api/exam/records', payload)
}

export function updateExamRecord(id: number, payload: Omit<ExamRecord, 'id'>) {
  return http.put<never, ExamRecord>(`/api/exam/records/${id}`, payload)
}

export function deleteExamRecord(id: number) {
  return http.delete(`/api/exam/records/${id}`)
}
