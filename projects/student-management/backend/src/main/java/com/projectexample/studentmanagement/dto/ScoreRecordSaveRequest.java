package com.projectexample.studentmanagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ScoreRecordSaveRequest {

    @NotBlank(message = "Student number is required")
    private String studentNo;

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotBlank(message = "Term is required")
    private String termName;

    @NotNull(message = "Score is required")
    @DecimalMin(value = "0.0", message = "Score must be greater than or equal to 0")
    private BigDecimal scoreValue;

    @NotNull(message = "Status is required")
    private Integer status;
}
