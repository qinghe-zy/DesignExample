package com.projectexample.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordSaveRequest {

    @NotBlank(message = "Reader number is required")
    private String readerNo;

    @NotBlank(message = "Reader name is required")
    private String readerName;

    @NotBlank(message = "Book title is required")
    private String bookTitle;

    @NotNull(message = "Borrow date is required")
    private LocalDate borrowDate;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    private LocalDate returnDate;

    @NotNull(message = "Status is required")
    private Integer status;
}
