package com.projectexample.librarymanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.librarymanagement.dto.BookCatalogSaveRequest;
import com.projectexample.librarymanagement.entity.BookCatalog;
import com.projectexample.librarymanagement.exception.BusinessException;
import com.projectexample.librarymanagement.mapper.BookCatalogMapper;
import com.projectexample.librarymanagement.service.BookCatalogService;
import com.projectexample.librarymanagement.vo.BookCatalogVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCatalogServiceImpl implements BookCatalogService {

    private final BookCatalogMapper bookCatalogMapper;

    @Override
    public List<BookCatalogVO> listBooks() {
        return bookCatalogMapper.selectList(Wrappers.lambdaQuery(BookCatalog.class).orderByAsc(BookCatalog::getCategory, BookCatalog::getTitle))
                .stream().map(this::toVO).toList();
    }

    @Override
    public BookCatalogVO createBook(BookCatalogSaveRequest request) {
        BookCatalog entity = new BookCatalog();
        apply(entity, request);
        bookCatalogMapper.insert(entity);
        return toVO(requireEntity(entity.getId()));
    }

    @Override
    public BookCatalogVO updateBook(Long id, BookCatalogSaveRequest request) {
        BookCatalog entity = requireEntity(id);
        apply(entity, request);
        bookCatalogMapper.updateById(entity);
        return toVO(requireEntity(id));
    }

    @Override
    public void deleteBook(Long id) {
        requireEntity(id);
        bookCatalogMapper.deleteById(id);
    }

    private BookCatalog requireEntity(Long id) {
        BookCatalog entity = bookCatalogMapper.selectById(id);
        if (entity == null) throw new BusinessException(4040, "Book record not found");
        return entity;
    }

    private void apply(BookCatalog entity, BookCatalogSaveRequest request) {
        entity.setBookCode(request.getBookCode());
        entity.setTitle(request.getTitle());
        entity.setCategory(request.getCategory());
        entity.setAuthor(request.getAuthor());
        entity.setPublisher(request.getPublisher());
        entity.setStock(request.getStock());
        entity.setStatus(request.getStatus());
    }

    private BookCatalogVO toVO(BookCatalog entity) {
        return BookCatalogVO.builder().id(entity.getId()).bookCode(entity.getBookCode()).title(entity.getTitle()).category(entity.getCategory()).author(entity.getAuthor()).publisher(entity.getPublisher()).stock(entity.getStock()).status(entity.getStatus()).build();
    }
}
