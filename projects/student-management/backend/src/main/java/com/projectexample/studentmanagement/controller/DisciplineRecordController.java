package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.dto.DisciplineRecordSaveRequest;
import com.projectexample.studentmanagement.service.DisciplineRecordService;
import com.projectexample.studentmanagement.vo.DisciplineRecordVO;
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
@RequestMapping("/api/student/discipline-records")
@RequiredArgsConstructor
public class DisciplineRecordController {

    private final DisciplineRecordService disciplineRecordService;

    @GetMapping
    public ApiResponse<List<DisciplineRecordVO>> list() {
        return ApiResponse.success(disciplineRecordService.listRecords());
    }

    @PostMapping
    public ApiResponse<DisciplineRecordVO> create(@Valid @RequestBody DisciplineRecordSaveRequest request) {
        return ApiResponse.success("record created", disciplineRecordService.createRecord(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<DisciplineRecordVO> update(@PathVariable Long id, @Valid @RequestBody DisciplineRecordSaveRequest request) {
        return ApiResponse.success("record updated", disciplineRecordService.updateRecord(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        disciplineRecordService.deleteRecord(id);
        return ApiResponse.success("record deleted", null);
    }
}
