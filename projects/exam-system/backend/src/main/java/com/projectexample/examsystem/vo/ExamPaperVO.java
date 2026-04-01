package com.projectexample.examsystem.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExamPaperVO {

    private Long id;
    private String paperName;
    private String courseName;
    private Integer durationMinutes;
    private Integer totalScore;
    private Integer publishStatus;
}
