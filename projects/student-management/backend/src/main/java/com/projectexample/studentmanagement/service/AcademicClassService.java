package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.dto.AcademicClassSaveRequest;
import com.projectexample.studentmanagement.vo.AcademicClassVO;

import java.util.List;

public interface AcademicClassService {

    List<AcademicClassVO> listClasses();

    AcademicClassVO createClass(AcademicClassSaveRequest request);

    AcademicClassVO updateClass(Long id, AcademicClassSaveRequest request);

    void deleteClass(Long id);
}
