package com.projectexample.baseadmin.service;

import com.projectexample.baseadmin.common.PageResponse;
import com.projectexample.baseadmin.dto.NoticeCreateRequest;
import com.projectexample.baseadmin.dto.NoticeQueryRequest;
import com.projectexample.baseadmin.dto.NoticeUpdateRequest;
import com.projectexample.baseadmin.vo.NoticeVO;

public interface NoticeService {

    PageResponse<NoticeVO> pageNotices(NoticeQueryRequest request);

    NoticeVO getNotice(Long id);

    NoticeVO createNotice(NoticeCreateRequest request);

    NoticeVO updateNotice(Long id, NoticeUpdateRequest request);

    void deleteNotice(Long id);
}
