package com.projectexample.studentmanagement.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DisciplineRecordVO {

    private Long id;
    private String studentNo;
    private String studentName;
    private String recordType;
    private String description;
    private LocalDate recordDate;
    private Integer status;
}
