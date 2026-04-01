package com.projectexample.examsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuestionBankSaveRequest {

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "Question type is required")
    private String questionType;

    @NotBlank(message = "Difficulty level is required")
    private String difficultyLevel;

    @NotBlank(message = "Question stem is required")
    private String stem;

    @NotBlank(message = "Answer key is required")
    private String answerKey;

    @NotNull(message = "Status is required")
    private Integer status;
}
