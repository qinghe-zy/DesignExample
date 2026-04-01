package com.projectexample.studentmanagement.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentProfileVO {

    private Long id;
    private String studentNo;
    private String studentName;
    private String gender;
    private String className;
    private String majorName;
    private String phone;
    private Integer status;
}
