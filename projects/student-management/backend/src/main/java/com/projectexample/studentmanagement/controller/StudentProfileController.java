package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.dto.StudentProfileSaveRequest;
import com.projectexample.studentmanagement.service.StudentProfileService;
import com.projectexample.studentmanagement.vo.StudentProfileVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/profiles")
@RequiredArgsConstructor
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @GetMapping
    public ApiResponse<List<StudentProfileVO>> list() {
        return ApiResponse.success(studentProfileService.listStudents());
    }

    @PostMapping
    public ApiResponse<StudentProfileVO> create(@Valid @RequestBody StudentProfileSaveRequest request) {
        return ApiResponse.success("student created", studentProfileService.createStudent(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentProfileVO> update(@PathVariable Long id, @Valid @RequestBody StudentProfileSaveRequest request) {
        return ApiResponse.success("student updated", studentProfileService.updateStudent(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        studentProfileService.deleteStudent(id);
        return ApiResponse.success("student deleted", null);
    }
}
