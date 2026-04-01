package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.common.PageResponse;
import com.projectexample.librarymanagement.dto.NoticeCreateRequest;
import com.projectexample.librarymanagement.dto.NoticeQueryRequest;
import com.projectexample.librarymanagement.dto.NoticeUpdateRequest;
import com.projectexample.librarymanagement.vo.NoticeVO;

public interface NoticeService {

    PageResponse<NoticeVO> pageNotices(NoticeQueryRequest request);

    NoticeVO getNotice(Long id);

    NoticeVO createNotice(NoticeCreateRequest request);

    NoticeVO updateNotice(Long id, NoticeUpdateRequest request);

    void deleteNotice(Long id);
}
