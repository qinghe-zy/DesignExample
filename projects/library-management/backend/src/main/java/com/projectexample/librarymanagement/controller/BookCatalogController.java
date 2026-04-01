package com.projectexample.librarymanagement.controller;

import com.projectexample.librarymanagement.common.ApiResponse;
import com.projectexample.librarymanagement.dto.BookCatalogSaveRequest;
import com.projectexample.librarymanagement.service.BookCatalogService;
import com.projectexample.librarymanagement.vo.BookCatalogVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/books")
@RequiredArgsConstructor
public class BookCatalogController {

    private final BookCatalogService bookCatalogService;

    @GetMapping
    public ApiResponse<List<BookCatalogVO>> list() { return ApiResponse.success(bookCatalogService.listBooks()); }

    @PostMapping
    public ApiResponse<BookCatalogVO> create(@Valid @RequestBody BookCatalogSaveRequest request) { return ApiResponse.success("book created", bookCatalogService.createBook(request)); }

    @PutMapping("/{id}")
    public ApiResponse<BookCatalogVO> update(@PathVariable Long id, @Valid @RequestBody BookCatalogSaveRequest request) { return ApiResponse.success("book updated", bookCatalogService.updateBook(id, request)); }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) { bookCatalogService.deleteBook(id); return ApiResponse.success("book deleted", null); }
}
