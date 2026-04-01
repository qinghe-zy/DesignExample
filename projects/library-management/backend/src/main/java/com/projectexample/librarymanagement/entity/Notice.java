package com.projectexample.librarymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.librarymanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@TableName("biz_notice")
@EqualsAndHashCode(callSuper = true)
public class Notice extends BaseEntity {

    private String title;
    private String category;
    private Integer status;
    private String content;

    @TableField("publish_time")
    private LocalDateTime publishTime;
}
