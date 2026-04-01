package com.projectexample.examsystem.controller;

import com.projectexample.examsystem.common.ApiResponse;
import com.projectexample.examsystem.dto.ExamRecordSaveRequest;
import com.projectexample.examsystem.service.ExamRecordService;
import com.projectexample.examsystem.vo.ExamRecordVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam/records")
@RequiredArgsConstructor
public class ExamRecordController {

    private final ExamRecordService examRecordService;

    @GetMapping
    public ApiResponse<List<ExamRecordVO>> list() { return ApiResponse.success(examRecordService.listRecords()); }

    @PostMapping
    public ApiResponse<ExamRecordVO> create(@Valid @RequestBody ExamRecordSaveRequest request) { return ApiResponse.success("record created", examRecordService.createRecord(request)); }

    @PutMapping("/{id}")
    public ApiResponse<ExamRecordVO> update(@PathVariable Long id, @Valid @RequestBody ExamRecordSaveRequest request) { return ApiResponse.success("record updated", examRecordService.updateRecord(id, request)); }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) { examRecordService.deleteRecord(id); return ApiResponse.success("record deleted", null); }
}
