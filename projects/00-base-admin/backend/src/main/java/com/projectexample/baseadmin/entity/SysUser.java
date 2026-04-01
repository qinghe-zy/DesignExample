package com.projectexample.baseadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.baseadmin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private String username;
    private String password;
    private String nickname;
    private String roleCode;
    private Integer status;
}
