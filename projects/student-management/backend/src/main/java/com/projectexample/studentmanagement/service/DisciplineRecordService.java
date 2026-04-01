package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.dto.DisciplineRecordSaveRequest;
import com.projectexample.studentmanagement.vo.DisciplineRecordVO;

import java.util.List;

public interface DisciplineRecordService {

    List<DisciplineRecordVO> listRecords();

    DisciplineRecordVO createRecord(DisciplineRecordSaveRequest request);

    DisciplineRecordVO updateRecord(Long id, DisciplineRecordSaveRequest request);

    void deleteRecord(Long id);
}
