package com.projectexample.examsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.examsystem.dto.ExamPaperSaveRequest;
import com.projectexample.examsystem.entity.ExamPaper;
import com.projectexample.examsystem.exception.BusinessException;
import com.projectexample.examsystem.mapper.ExamPaperMapper;
import com.projectexample.examsystem.service.ExamPaperService;
import com.projectexample.examsystem.vo.ExamPaperVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamPaperServiceImpl implements ExamPaperService {

    private final ExamPaperMapper examPaperMapper;

    @Override
    public List<ExamPaperVO> listPapers() {
        return examPaperMapper.selectList(Wrappers.lambdaQuery(ExamPaper.class).orderByDesc(ExamPaper::getUpdateTime))
                .stream().map(this::toVO).toList();
    }

    @Override
    public ExamPaperVO createPaper(ExamPaperSaveRequest request) { ExamPaper entity = new ExamPaper(); apply(entity, request); examPaperMapper.insert(entity); return toVO(requireEntity(entity.getId())); }

    @Override
    public ExamPaperVO updatePaper(Long id, ExamPaperSaveRequest request) { ExamPaper entity = requireEntity(id); apply(entity, request); examPaperMapper.updateById(entity); return toVO(requireEntity(id)); }

    @Override
    public void deletePaper(Long id) { requireEntity(id); examPaperMapper.deleteById(id); }

    private ExamPaper requireEntity(Long id) { ExamPaper entity = examPaperMapper.selectById(id); if (entity == null) throw new BusinessException(4040, "Exam paper not found"); return entity; }
    private void apply(ExamPaper entity, ExamPaperSaveRequest request) { entity.setPaperName(request.getPaperName()); entity.setCourseName(request.getCourseName()); entity.setDurationMinutes(request.getDurationMinutes()); entity.setTotalScore(request.getTotalScore()); entity.setPublishStatus(request.getPublishStatus()); }
    private ExamPaperVO toVO(ExamPaper entity) { return ExamPaperVO.builder().id(entity.getId()).paperName(entity.getPaperName()).courseName(entity.getCourseName()).durationMinutes(entity.getDurationMinutes()).totalScore(entity.getTotalScore()).publishStatus(entity.getPublishStatus()).build(); }
}
