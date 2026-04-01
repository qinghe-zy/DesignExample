package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.entity.SysUser;
import com.projectexample.studentmanagement.vo.SysUserVO;

import java.util.List;

public interface SysUserService {

    SysUser findByUsername(String username);

    List<SysUserVO> listUsers();
}

