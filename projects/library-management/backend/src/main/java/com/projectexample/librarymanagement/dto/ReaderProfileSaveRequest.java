package com.projectexample.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReaderProfileSaveRequest {

    @NotBlank(message = "Reader number is required")
    private String readerNo;

    @NotBlank(message = "Reader name is required")
    private String readerName;

    @NotBlank(message = "Reader type is required")
    private String readerType;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull(message = "Status is required")
    private Integer status;
}
