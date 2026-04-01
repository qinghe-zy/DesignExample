package com.projectexample.librarymanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.librarymanagement.dto.BorrowRecordSaveRequest;
import com.projectexample.librarymanagement.entity.BorrowRecord;
import com.projectexample.librarymanagement.exception.BusinessException;
import com.projectexample.librarymanagement.mapper.BorrowRecordMapper;
import com.projectexample.librarymanagement.service.BorrowRecordService;
import com.projectexample.librarymanagement.vo.BorrowRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<BorrowRecordVO> listRecords() {
        return borrowRecordMapper.selectList(Wrappers.lambdaQuery(BorrowRecord.class).orderByDesc(BorrowRecord::getBorrowDate))
                .stream().map(this::toVO).toList();
    }

    @Override
    public BorrowRecordVO createRecord(BorrowRecordSaveRequest request) {
        BorrowRecord entity = new BorrowRecord();
        apply(entity, request);
        borrowRecordMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public BorrowRecordVO updateRecord(Long id, BorrowRecordSaveRequest request) {
        BorrowRecord entity = requireEntity(id);
        apply(entity, request);
        borrowRecordMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteRecord(Long id) {
        requireEntity(id);
        borrowRecordMapper.deleteById(id);
    }

    private BorrowRecord requireEntity(Long id) {
        BorrowRecord entity = borrowRecordMapper.selectById(id);
        if (entity == null) throw new BusinessException(4040, "Borrow record not found");
        return entity;
    }

    private void apply(BorrowRecord entity, BorrowRecordSaveRequest request) {
        entity.setReaderNo(request.getReaderNo());
        entity.setReaderName(request.getReaderName());
        entity.setBookTitle(request.getBookTitle());
        entity.setBorrowDate(request.getBorrowDate());
        entity.setDueDate(request.getDueDate());
        entity.setReturnDate(request.getReturnDate());
        entity.setStatus(request.getStatus());
    }

    private BorrowRecordVO toVO(BorrowRecord entity) {
        return BorrowRecordVO.builder().id(entity.getId()).readerNo(entity.getReaderNo()).readerName(entity.getReaderName()).bookTitle(entity.getBookTitle()).borrowDate(entity.getBorrowDate()).dueDate(entity.getDueDate()).returnDate(entity.getReturnDate()).status(entity.getStatus()).build();
    }
}
