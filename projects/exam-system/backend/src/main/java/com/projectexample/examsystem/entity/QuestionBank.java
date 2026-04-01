package com.projectexample.examsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.examsystem.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_question_bank")
@EqualsAndHashCode(callSuper = true)
public class QuestionBank extends BaseEntity {

    private String subject;
    private String questionType;
    private String difficultyLevel;
    private String stem;
    private String answerKey;
    private Integer status;
}
