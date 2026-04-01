package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.dto.AcademicClassSaveRequest;
import com.projectexample.studentmanagement.entity.AcademicClass;
import com.projectexample.studentmanagement.exception.BusinessException;
import com.projectexample.studentmanagement.mapper.AcademicClassMapper;
import com.projectexample.studentmanagement.service.AcademicClassService;
import com.projectexample.studentmanagement.vo.AcademicClassVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicClassServiceImpl implements AcademicClassService {

    private final AcademicClassMapper academicClassMapper;

    @Override
    public List<AcademicClassVO> listClasses() {
        return academicClassMapper.selectList(Wrappers.lambdaQuery(AcademicClass.class)
                        .orderByAsc(AcademicClass::getGradeLevel, AcademicClass::getClassName))
                .stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public AcademicClassVO createClass(AcademicClassSaveRequest request) {
        AcademicClass entity = new AcademicClass();
        apply(entity, request);
        academicClassMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public AcademicClassVO updateClass(Long id, AcademicClassSaveRequest request) {
        AcademicClass entity = requireEntity(id);
        apply(entity, request);
        academicClassMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteClass(Long id) {
        requireEntity(id);
        academicClassMapper.deleteById(id);
    }

    private AcademicClass requireEntity(Long id) {
        AcademicClass entity = academicClassMapper.selectById(id);
        if (entity == null) {
            throw new BusinessException(4040, "Class record not found");
        }
        return entity;
    }

    private void apply(AcademicClass entity, AcademicClassSaveRequest request) {
        entity.setClassName(request.getClassName());
        entity.setMajorName(request.getMajorName());
        entity.setGradeLevel(request.getGradeLevel());
        entity.setCounselor(request.getCounselor());
        entity.setStatus(request.getStatus());
    }

    private AcademicClassVO toVO(AcademicClass entity) {
        return AcademicClassVO.builder()
                .id(entity.getId())
                .className(entity.getClassName())
                .majorName(entity.getMajorName())
                .gradeLevel(entity.getGradeLevel())
                .counselor(entity.getCounselor())
                .status(entity.getStatus())
                .build();
    }
}
