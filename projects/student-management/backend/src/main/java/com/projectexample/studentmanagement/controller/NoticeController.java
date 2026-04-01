package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.common.PageResponse;
import com.projectexample.studentmanagement.dto.NoticeCreateRequest;
import com.projectexample.studentmanagement.dto.NoticeQueryRequest;
import com.projectexample.studentmanagement.dto.NoticeUpdateRequest;
import com.projectexample.studentmanagement.service.NoticeService;
import com.projectexample.studentmanagement.vo.NoticeVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ApiResponse<PageResponse<NoticeVO>> page(@ModelAttribute NoticeQueryRequest request) {
        return ApiResponse.success(noticeService.pageNotices(request));
    }

    @GetMapping("/{id}")
    public ApiResponse<NoticeVO> detail(@PathVariable Long id) {
        return ApiResponse.success(noticeService.getNotice(id));
    }

    @PostMapping
    public ApiResponse<NoticeVO> create(@Valid @RequestBody NoticeCreateRequest request) {
        return ApiResponse.success("notice created", noticeService.createNotice(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<NoticeVO> update(@PathVariable Long id, @Valid @RequestBody NoticeUpdateRequest request) {
        return ApiResponse.success("notice updated", noticeService.updateNotice(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ApiResponse.success("notice deleted", null);
    }
}

