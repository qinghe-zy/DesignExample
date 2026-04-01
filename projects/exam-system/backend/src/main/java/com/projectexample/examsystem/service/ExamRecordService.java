package com.projectexample.examsystem.service;

import com.projectexample.examsystem.dto.ExamRecordSaveRequest;
import com.projectexample.examsystem.vo.ExamRecordVO;

import java.util.List;

public interface ExamRecordService {

    List<ExamRecordVO> listRecords();

    ExamRecordVO createRecord(ExamRecordSaveRequest request);

    ExamRecordVO updateRecord(Long id, ExamRecordSaveRequest request);

    void deleteRecord(Long id);
}
