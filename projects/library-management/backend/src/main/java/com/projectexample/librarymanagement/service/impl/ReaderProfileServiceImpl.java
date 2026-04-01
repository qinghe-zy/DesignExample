package com.projectexample.librarymanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.librarymanagement.dto.ReaderProfileSaveRequest;
import com.projectexample.librarymanagement.entity.ReaderProfile;
import com.projectexample.librarymanagement.exception.BusinessException;
import com.projectexample.librarymanagement.mapper.ReaderProfileMapper;
import com.projectexample.librarymanagement.service.ReaderProfileService;
import com.projectexample.librarymanagement.vo.ReaderProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderProfileServiceImpl implements ReaderProfileService {

    private final ReaderProfileMapper readerProfileMapper;

    @Override
    public List<ReaderProfileVO> listReaders() {
        return readerProfileMapper.selectList(Wrappers.lambdaQuery(ReaderProfile.class).orderByAsc(ReaderProfile::getReaderNo))
                .stream().map(this::toVO).toList();
    }

    @Override
    public ReaderProfileVO createReader(ReaderProfileSaveRequest request) {
        ReaderProfile entity = new ReaderProfile();
        apply(entity, request);
        readerProfileMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public ReaderProfileVO updateReader(Long id, ReaderProfileSaveRequest request) {
        ReaderProfile entity = requireEntity(id);
        apply(entity, request);
        readerProfileMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteReader(Long id) {
        requireEntity(id);
        readerProfileMapper.deleteById(id);
    }

    private ReaderProfile requireEntity(Long id) {
        ReaderProfile entity = readerProfileMapper.selectById(id);
        if (entity == null) throw new BusinessException(4040, "Reader record not found");
        return entity;
    }

    private void apply(ReaderProfile entity, ReaderProfileSaveRequest request) {
        entity.setReaderNo(request.getReaderNo());
        entity.setReaderName(request.getReaderName());
        entity.setReaderType(request.getReaderType());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
    }

    private ReaderProfileVO toVO(ReaderProfile entity) {
        return ReaderProfileVO.builder().id(entity.getId()).readerNo(entity.getReaderNo()).readerName(entity.getReaderName()).readerType(entity.getReaderType()).phone(entity.getPhone()).status(entity.getStatus()).build();
    }
}
