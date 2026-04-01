package com.projectexample.librarymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.librarymanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private String roleCode;
    private String roleName;
    private String remark;
}
