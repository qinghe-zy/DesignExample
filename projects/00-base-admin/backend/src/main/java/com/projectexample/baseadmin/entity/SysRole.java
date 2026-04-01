package com.projectexample.baseadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.baseadmin.common.BaseEntity;
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
