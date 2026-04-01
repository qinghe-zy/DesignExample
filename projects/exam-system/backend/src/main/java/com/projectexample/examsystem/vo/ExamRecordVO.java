package com.projectexample.examsystem.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExamRecordVO {

    private Long id;
    private String studentName;
    private String paperName;
    private LocalDate attemptDate;
    private Double scoreValue;
    private Integer status;
}
