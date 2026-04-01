package com.projectexample.examsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.examsystem.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@TableName("biz_exam_record")
@EqualsAndHashCode(callSuper = true)
public class ExamRecord extends BaseEntity {

    private String studentName;
    private String paperName;

    @TableField("attempt_date")
    private LocalDate attemptDate;

    private Double scoreValue;
    private Integer status;
}
