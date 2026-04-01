package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.dto.StudentProfileSaveRequest;
import com.projectexample.studentmanagement.entity.StudentProfile;
import com.projectexample.studentmanagement.exception.BusinessException;
import com.projectexample.studentmanagement.mapper.StudentProfileMapper;
import com.projectexample.studentmanagement.service.StudentProfileService;
import com.projectexample.studentmanagement.vo.StudentProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileMapper studentProfileMapper;

    @Override
    public List<StudentProfileVO> listStudents() {
        return studentProfileMapper.selectList(Wrappers.lambdaQuery(StudentProfile.class)
                        .orderByAsc(StudentProfile::getStudentNo))
                .stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public StudentProfileVO createStudent(StudentProfileSaveRequest request) {
        StudentProfile entity = new StudentProfile();
        apply(entity, request);
        studentProfileMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public StudentProfileVO updateStudent(Long id, StudentProfileSaveRequest request) {
        StudentProfile entity = requireEntity(id);
        apply(entity, request);
        studentProfileMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteStudent(Long id) {
        requireEntity(id);
        studentProfileMapper.deleteById(id);
    }

    private StudentProfile requireEntity(Long id) {
        StudentProfile entity = studentProfileMapper.selectById(id);
        if (entity == null) {
            throw new BusinessException(4040, "Student record not found");
        }
        return entity;
    }

    private void apply(StudentProfile entity, StudentProfileSaveRequest request) {
        entity.setStudentNo(request.getStudentNo());
        entity.setStudentName(request.getStudentName());
        entity.setGender(request.getGender());
        entity.setClassName(request.getClassName());
        entity.setMajorName(request.getMajorName());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
    }

    private StudentProfileVO toVO(StudentProfile entity) {
        return StudentProfileVO.builder()
                .id(entity.getId())
                .studentNo(entity.getStudentNo())
                .studentName(entity.getStudentName())
                .gender(entity.getGender())
                .className(entity.getClassName())
                .majorName(entity.getMajorName())
                .phone(entity.getPhone())
                .status(entity.getStatus())
                .build();
    }
}
