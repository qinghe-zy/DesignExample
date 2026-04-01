package com.projectexample.studentmanagement.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcademicClassVO {

    private Long id;
    private String className;
    private String majorName;
    private String gradeLevel;
    private String counselor;
    private Integer status;
}
