package com.projectexample.examsystem.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionBankVO {

    private Long id;
    private String subject;
    private String questionType;
    private String difficultyLevel;
    private String stem;
    private String answerKey;
    private Integer status;
}
