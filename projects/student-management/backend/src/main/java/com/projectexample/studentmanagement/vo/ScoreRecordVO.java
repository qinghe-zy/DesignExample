package com.projectexample.studentmanagement.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ScoreRecordVO {

    private Long id;
    private String studentNo;
    private String studentName;
    private String courseName;
    private String termName;
    private BigDecimal scoreValue;
    private Integer status;
}
