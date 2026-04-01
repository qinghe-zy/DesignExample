package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.dto.StudentProfileSaveRequest;
import com.projectexample.studentmanagement.vo.StudentProfileVO;

import java.util.List;

public interface StudentProfileService {

    List<StudentProfileVO> listStudents();

    StudentProfileVO createStudent(StudentProfileSaveRequest request);

    StudentProfileVO updateStudent(Long id, StudentProfileSaveRequest request);

    void deleteStudent(Long id);
}
