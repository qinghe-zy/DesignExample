package com.projectexample.studentmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.studentmanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_student_class")
@EqualsAndHashCode(callSuper = true)
public class AcademicClass extends BaseEntity {

    private String className;
    private String majorName;
    private String gradeLevel;
    private String counselor;
    private Integer status;
}
