package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.dto.BorrowRecordSaveRequest;
import com.projectexample.librarymanagement.vo.BorrowRecordVO;

import java.util.List;

public interface BorrowRecordService {

    List<BorrowRecordVO> listRecords();

    BorrowRecordVO createRecord(BorrowRecordSaveRequest request);

    BorrowRecordVO updateRecord(Long id, BorrowRecordSaveRequest request);

    void deleteRecord(Long id);
}
