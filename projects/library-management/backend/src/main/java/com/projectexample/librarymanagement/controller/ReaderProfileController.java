package com.projectexample.librarymanagement.controller;

import com.projectexample.librarymanagement.common.ApiResponse;
import com.projectexample.librarymanagement.dto.ReaderProfileSaveRequest;
import com.projectexample.librarymanagement.service.ReaderProfileService;
import com.projectexample.librarymanagement.vo.ReaderProfileVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/readers")
@RequiredArgsConstructor
public class ReaderProfileController {

    private final ReaderProfileService readerProfileService;

    @GetMapping
    public ApiResponse<List<ReaderProfileVO>> list() { return ApiResponse.success(readerProfileService.listReaders()); }

    @PostMapping
    public ApiResponse<ReaderProfileVO> create(@Valid @RequestBody ReaderProfileSaveRequest request) { return ApiResponse.success("reader created", readerProfileService.createReader(request)); }

    @PutMapping("/{id}")
    public ApiResponse<ReaderProfileVO> update(@PathVariable Long id, @Valid @RequestBody ReaderProfileSaveRequest request) { return ApiResponse.success("reader updated", readerProfileService.updateReader(id, request)); }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) { readerProfileService.deleteReader(id); return ApiResponse.success("reader deleted", null); }
}
