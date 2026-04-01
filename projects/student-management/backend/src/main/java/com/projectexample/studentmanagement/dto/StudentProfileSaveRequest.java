package com.projectexample.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentProfileSaveRequest {

    @NotBlank(message = "Student number is required")
    private String studentNo;

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Class name is required")
    private String className;

    @NotBlank(message = "Major name is required")
    private String majorName;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull(message = "Status is required")
    private Integer status;
}
