package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.dto.DisciplineRecordSaveRequest;
import com.projectexample.studentmanagement.entity.DisciplineRecord;
import com.projectexample.studentmanagement.exception.BusinessException;
import com.projectexample.studentmanagement.mapper.DisciplineRecordMapper;
import com.projectexample.studentmanagement.service.DisciplineRecordService;
import com.projectexample.studentmanagement.vo.DisciplineRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplineRecordServiceImpl implements DisciplineRecordService {

    private final DisciplineRecordMapper disciplineRecordMapper;

    @Override
    public List<DisciplineRecordVO> listRecords() {
        return disciplineRecordMapper.selectList(Wrappers.lambdaQuery(DisciplineRecord.class)
                        .orderByDesc(DisciplineRecord::getRecordDate))
                .stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public DisciplineRecordVO createRecord(DisciplineRecordSaveRequest request) {
        DisciplineRecord entity = new DisciplineRecord();
        apply(entity, request);
        disciplineRecordMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public DisciplineRecordVO updateRecord(Long id, DisciplineRecordSaveRequest request) {
        DisciplineRecord entity = requireEntity(id);
        apply(entity, request);
        disciplineRecordMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteRecord(Long id) {
        requireEntity(id);
        disciplineRecordMapper.deleteById(id);
    }

    private DisciplineRecord requireEntity(Long id) {
        DisciplineRecord entity = disciplineRecordMapper.selectById(id);
        if (entity == null) {
            throw new BusinessException(4040, "Discipline record not found");
        }
        return entity;
    }

    private void apply(DisciplineRecord entity, DisciplineRecordSaveRequest request) {
        entity.setStudentNo(request.getStudentNo());
        entity.setStudentName(request.getStudentName());
        entity.setRecordType(request.getRecordType());
        entity.setDescription(request.getDescription());
        entity.setRecordDate(request.getRecordDate());
        entity.setStatus(request.getStatus());
    }

    private DisciplineRecordVO toVO(DisciplineRecord entity) {
        return DisciplineRecordVO.builder()
                .id(entity.getId())
                .studentNo(entity.getStudentNo())
                .studentName(entity.getStudentName())
                .recordType(entity.getRecordType())
                .description(entity.getDescription())
                .recordDate(entity.getRecordDate())
                .status(entity.getStatus())
                .build();
    }
}
