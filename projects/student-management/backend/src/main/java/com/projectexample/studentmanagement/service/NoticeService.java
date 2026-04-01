package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.common.PageResponse;
import com.projectexample.studentmanagement.dto.NoticeCreateRequest;
import com.projectexample.studentmanagement.dto.NoticeQueryRequest;
import com.projectexample.studentmanagement.dto.NoticeUpdateRequest;
import com.projectexample.studentmanagement.vo.NoticeVO;

public interface NoticeService {

    PageResponse<NoticeVO> pageNotices(NoticeQueryRequest request);

    NoticeVO getNotice(Long id);

    NoticeVO createNotice(NoticeCreateRequest request);

    NoticeVO updateNotice(Long id, NoticeUpdateRequest request);

    void deleteNotice(Long id);
}

