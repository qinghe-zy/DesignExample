package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.dto.ScoreRecordSaveRequest;
import com.projectexample.studentmanagement.entity.ScoreRecord;
import com.projectexample.studentmanagement.exception.BusinessException;
import com.projectexample.studentmanagement.mapper.ScoreRecordMapper;
import com.projectexample.studentmanagement.service.ScoreRecordService;
import com.projectexample.studentmanagement.vo.ScoreRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreRecordServiceImpl implements ScoreRecordService {

    private final ScoreRecordMapper scoreRecordMapper;

    @Override
    public List<ScoreRecordVO> listScores() {
        return scoreRecordMapper.selectList(Wrappers.lambdaQuery(ScoreRecord.class)
                        .orderByDesc(ScoreRecord::getUpdateTime))
                .stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public ScoreRecordVO createScore(ScoreRecordSaveRequest request) {
        ScoreRecord entity = new ScoreRecord();
        apply(entity, request);
        scoreRecordMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public ScoreRecordVO updateScore(Long id, ScoreRecordSaveRequest request) {
        ScoreRecord entity = requireEntity(id);
        apply(entity, request);
        scoreRecordMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteScore(Long id) {
        requireEntity(id);
        scoreRecordMapper.deleteById(id);
    }

    private ScoreRecord requireEntity(Long id) {
        ScoreRecord entity = scoreRecordMapper.selectById(id);
        if (entity == null) {
            throw new BusinessException(4040, "Score record not found");
        }
        return entity;
    }

    private void apply(ScoreRecord entity, ScoreRecordSaveRequest request) {
        entity.setStudentNo(request.getStudentNo());
        entity.setStudentName(request.getStudentName());
        entity.setCourseName(request.getCourseName());
        entity.setTermName(request.getTermName());
        entity.setScoreValue(request.getScoreValue());
        entity.setStatus(request.getStatus());
    }

    private ScoreRecordVO toVO(ScoreRecord entity) {
        return ScoreRecordVO.builder()
                .id(entity.getId())
                .studentNo(entity.getStudentNo())
                .studentName(entity.getStudentName())
                .courseName(entity.getCourseName())
                .termName(entity.getTermName())
                .scoreValue(entity.getScoreValue())
                .status(entity.getStatus())
                .build();
    }
}
