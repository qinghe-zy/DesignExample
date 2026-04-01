package com.projectexample.examsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.examsystem.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_exam_paper")
@EqualsAndHashCode(callSuper = true)
public class ExamPaper extends BaseEntity {

    private String paperName;
    private String courseName;
    private Integer durationMinutes;
    private Integer totalScore;
    private Integer publishStatus;
}
