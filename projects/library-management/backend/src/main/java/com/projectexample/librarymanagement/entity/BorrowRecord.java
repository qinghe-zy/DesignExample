package com.projectexample.librarymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.librarymanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@TableName("biz_borrow_record")
@EqualsAndHashCode(callSuper = true)
public class BorrowRecord extends BaseEntity {

    private String readerNo;
    private String readerName;
    private String bookTitle;

    @TableField("borrow_date")
    private LocalDate borrowDate;

    @TableField("due_date")
    private LocalDate dueDate;

    @TableField("return_date")
    private LocalDate returnDate;

    private Integer status;
}
