package com.projectexample.librarymanagement.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCatalogVO {

    private Long id;
    private String bookCode;
    private String title;
    private String category;
    private String author;
    private String publisher;
    private Integer stock;
    private Integer status;
}
