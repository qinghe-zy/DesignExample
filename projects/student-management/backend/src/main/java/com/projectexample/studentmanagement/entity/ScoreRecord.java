package com.projectexample.studentmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.studentmanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@TableName("biz_score_record")
@EqualsAndHashCode(callSuper = true)
public class ScoreRecord extends BaseEntity {

    private String studentNo;
    private String studentName;
    private String courseName;
    private String termName;
    private BigDecimal scoreValue;
    private Integer status;
}
