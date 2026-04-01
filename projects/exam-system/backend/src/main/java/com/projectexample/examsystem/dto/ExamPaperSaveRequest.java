package com.projectexample.examsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExamPaperSaveRequest {

    @NotBlank(message = "Paper name is required")
    private String paperName;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be greater than 0")
    private Integer durationMinutes;

    @NotNull(message = "Total score is required")
    @Min(value = 1, message = "Total score must be greater than 0")
    private Integer totalScore;

    @NotNull(message = "Publish status is required")
    private Integer publishStatus;
}
