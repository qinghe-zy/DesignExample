package com.projectexample.studentmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.studentmanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@TableName("biz_discipline_record")
@EqualsAndHashCode(callSuper = true)
public class DisciplineRecord extends BaseEntity {

    private String studentNo;
    private String studentName;
    private String recordType;
    private String description;

    @TableField("record_date")
    private LocalDate recordDate;

    private Integer status;
}
