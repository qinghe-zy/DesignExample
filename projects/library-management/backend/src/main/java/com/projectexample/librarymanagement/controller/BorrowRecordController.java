package com.projectexample.librarymanagement.controller;

import com.projectexample.librarymanagement.common.ApiResponse;
import com.projectexample.librarymanagement.dto.BorrowRecordSaveRequest;
import com.projectexample.librarymanagement.service.BorrowRecordService;
import com.projectexample.librarymanagement.vo.BorrowRecordVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/borrow-records")
@RequiredArgsConstructor
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    @GetMapping
    public ApiResponse<List<BorrowRecordVO>> list() { return ApiResponse.success(borrowRecordService.listRecords()); }

    @PostMapping
    public ApiResponse<BorrowRecordVO> create(@Valid @RequestBody BorrowRecordSaveRequest request) { return ApiResponse.success("borrow record created", borrowRecordService.createRecord(request)); }

    @PutMapping("/{id}")
    public ApiResponse<BorrowRecordVO> update(@PathVariable Long id, @Valid @RequestBody BorrowRecordSaveRequest request) { return ApiResponse.success("borrow record updated", borrowRecordService.updateRecord(id, request)); }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) { borrowRecordService.deleteRecord(id); return ApiResponse.success("borrow record deleted", null); }
}
