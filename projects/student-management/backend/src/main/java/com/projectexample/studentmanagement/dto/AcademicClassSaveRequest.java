package com.projectexample.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AcademicClassSaveRequest {

    @NotBlank(message = "Class name is required")
    private String className;

    @NotBlank(message = "Major name is required")
    private String majorName;

    @NotBlank(message = "Grade level is required")
    private String gradeLevel;

    @NotBlank(message = "Counselor is required")
    private String counselor;

    @NotNull(message = "Status is required")
    private Integer status;
}
