package com.projectexample.baseadmin.service;

import com.projectexample.baseadmin.entity.SysUser;
import com.projectexample.baseadmin.vo.SysUserVO;

import java.util.List;

public interface SysUserService {

    SysUser findByUsername(String username);

    List<SysUserVO> listUsers();
}
