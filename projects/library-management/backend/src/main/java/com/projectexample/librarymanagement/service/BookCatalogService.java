package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.dto.BookCatalogSaveRequest;
import com.projectexample.librarymanagement.vo.BookCatalogVO;

import java.util.List;

public interface BookCatalogService {

    List<BookCatalogVO> listBooks();

    BookCatalogVO createBook(BookCatalogSaveRequest request);

    BookCatalogVO updateBook(Long id, BookCatalogSaveRequest request);

    void deleteBook(Long id);
}
