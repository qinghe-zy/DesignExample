package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.vo.SysMenuVO;

import java.util.List;

public interface SysMenuService {

    List<SysMenuVO> listMenus();

    List<SysMenuVO> listCurrentMenus(String roleCode);
}

