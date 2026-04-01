package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.entity.SysUser;
import com.projectexample.librarymanagement.vo.SysUserVO;

import java.util.List;

public interface SysUserService {

    SysUser findByUsername(String username);

    List<SysUserVO> listUsers();
}
