package com.projectexample.studentmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.projectexample.studentmanagement.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("sys_menu")
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity {

    private String name;
    private String path;
    private String component;
    private String icon;

    @TableField("permission_code")
    private String permissionCode;

    @TableField("parent_id")
    private Long parentId;

    @TableField("sort_no")
    private Integer sortNo;

    @TableField("menu_type")
    private String menuType;
}

