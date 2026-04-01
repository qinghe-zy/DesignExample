package com.projectexample.studentmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.studentmanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_student_profile")
@EqualsAndHashCode(callSuper = true)
public class StudentProfile extends BaseEntity {

    private String studentNo;
    private String studentName;
    private String gender;
    private String className;
    private String majorName;
    private String phone;
    private Integer status;
}
