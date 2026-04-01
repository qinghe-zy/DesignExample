package com.projectexample.studentmanagement.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysUserVO {

    private Long id;
    private String username;
    private String nickname;
    private String roleCode;
    private Integer status;
}

