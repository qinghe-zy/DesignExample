package com.projectexample.librarymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.librarymanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_book_catalog")
@EqualsAndHashCode(callSuper = true)
public class BookCatalog extends BaseEntity {

    private String bookCode;
    private String title;
    private String category;
    private String author;
    private String publisher;
    private Integer stock;
    private Integer status;
}
