package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.dto.AcademicClassSaveRequest;
import com.projectexample.studentmanagement.service.AcademicClassService;
import com.projectexample.studentmanagement.vo.AcademicClassVO;
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
@RequestMapping("/api/student/classes")
@RequiredArgsConstructor
public class AcademicClassController {

    private final AcademicClassService academicClassService;

    @GetMapping
    public ApiResponse<List<AcademicClassVO>> list() {
        return ApiResponse.success(academicClassService.listClasses());
    }

    @PostMapping
    public ApiResponse<AcademicClassVO> create(@Valid @RequestBody AcademicClassSaveRequest request) {
        return ApiResponse.success("class created", academicClassService.createClass(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<AcademicClassVO> update(@PathVariable Long id, @Valid @RequestBody AcademicClassSaveRequest request) {
        return ApiResponse.success("class updated", academicClassService.updateClass(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        academicClassService.deleteClass(id);
        return ApiResponse.success("class deleted", null);
    }
}
