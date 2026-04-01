package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.dto.ScoreRecordSaveRequest;
import com.projectexample.studentmanagement.vo.ScoreRecordVO;

import java.util.List;

public interface ScoreRecordService {

    List<ScoreRecordVO> listScores();

    ScoreRecordVO createScore(ScoreRecordSaveRequest request);

    ScoreRecordVO updateScore(Long id, ScoreRecordSaveRequest request);

    void deleteScore(Long id);
}
