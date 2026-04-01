package com.projectexample.librarymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.librarymanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("biz_reader_profile")
@EqualsAndHashCode(callSuper = true)
public class ReaderProfile extends BaseEntity {

    private String readerNo;
    private String readerName;
    private String readerType;
    private String phone;
    private Integer status;
}
