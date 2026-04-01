package com.projectexample.examsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.examsystem.dto.ExamRecordSaveRequest;
import com.projectexample.examsystem.entity.ExamRecord;
import com.projectexample.examsystem.exception.BusinessException;
import com.projectexample.examsystem.mapper.ExamRecordMapper;
import com.projectexample.examsystem.service.ExamRecordService;
import com.projectexample.examsystem.vo.ExamRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamRecordServiceImpl implements ExamRecordService {

    private final ExamRecordMapper examRecordMapper;

    @Override
    public List<ExamRecordVO> listRecords() {
        return examRecordMapper.selectList(Wrappers.lambdaQuery(ExamRecord.class).orderByDesc(ExamRecord::getAttemptDate))
                .stream().map(this::toVO).toList();
    }

    @Override
    public ExamRecordVO createRecord(ExamRecordSaveRequest request) { ExamRecord entity = new ExamRecord(); apply(entity, request); examRecordMapper.insert(entity); return toVO(requireEntity(entity.getId())); }

    @Override
    public ExamRecordVO updateRecord(Long id, ExamRecordSaveRequest request) { ExamRecord entity = requireEntity(id); apply(entity, request); examRecordMapper.updateById(entity); return toVO(requireEntity(id)); }

    @Override
    public void deleteRecord(Long id) { requireEntity(id); examRecordMapper.deleteById(id); }

    private ExamRecord requireEntity(Long id) { ExamRecord entity = examRecordMapper.selectById(id); if (entity == null) throw new BusinessException(4040, "Exam record not found"); return entity; }
    private void apply(ExamRecord entity, ExamRecordSaveRequest request) { entity.setStudentName(request.getStudentName()); entity.setPaperName(request.getPaperName()); entity.setAttemptDate(request.getAttemptDate()); entity.setScoreValue(request.getScoreValue()); entity.setStatus(request.getStatus()); }
    private ExamRecordVO toVO(ExamRecord entity) { return ExamRecordVO.builder().id(entity.getId()).studentName(entity.getStudentName()).paperName(entity.getPaperName()).attemptDate(entity.getAttemptDate()).scoreValue(entity.getScoreValue()).status(entity.getStatus()).build(); }
}
