import http from './http'

export interface BookCatalog {
  id: number
  bookCode: string
  title: string
  category: string
  author: string
  publisher: string
  stock: number
  status: number
}

export interface ReaderProfile {
  id: number
  readerNo: string
  readerName: string
  readerType: string
  phone: string
  status: number
}

export interface BorrowRecord {
  id: number
  readerNo: string
  readerName: string
  bookTitle: string
  borrowDate: string
  dueDate: string
  returnDate: string | null
  status: number
}

export function fetchBooks() {
  return http.get<never, BookCatalog[]>('/api/library/books')
}

export function createBook(payload: Omit<BookCatalog, 'id'>) {
  return http.post<never, BookCatalog>('/api/library/books', payload)
}

export function updateBook(id: number, payload: Omit<BookCatalog, 'id'>) {
  return http.put<never, BookCatalog>(`/api/library/books/${id}`, payload)
}

export function deleteBook(id: number) {
  return http.delete(`/api/library/books/${id}`)
}

export function fetchReaders() {
  return http.get<never, ReaderProfile[]>('/api/library/readers')
}

export function createReader(payload: Omit<ReaderProfile, 'id'>) {
  return http.post<never, ReaderProfile>('/api/library/readers', payload)
}

export function updateReader(id: number, payload: Omit<ReaderProfile, 'id'>) {
  return http.put<never, ReaderProfile>(`/api/library/readers/${id}`, payload)
}

export function deleteReader(id: number) {
  return http.delete(`/api/library/readers/${id}`)
}

export function fetchBorrowRecords() {
  return http.get<never, BorrowRecord[]>('/api/library/borrow-records')
}

export function createBorrowRecord(payload: Omit<BorrowRecord, 'id'>) {
  return http.post<never, BorrowRecord>('/api/library/borrow-records', payload)
}

export function updateBorrowRecord(id: number, payload: Omit<BorrowRecord, 'id'>) {
  return http.put<never, BorrowRecord>(`/api/library/borrow-records/${id}`, payload)
}

export function deleteBorrowRecord(id: number) {
  return http.delete(`/api/library/borrow-records/${id}`)
}
