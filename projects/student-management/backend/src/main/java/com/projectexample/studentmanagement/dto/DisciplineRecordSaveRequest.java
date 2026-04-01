package com.projectexample.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DisciplineRecordSaveRequest {

    @NotBlank(message = "Student number is required")
    private String studentNo;

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Record type is required")
    private String recordType;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Record date is required")
    private LocalDate recordDate;

    @NotNull(message = "Status is required")
    private Integer status;
}
