package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.vo.SysMenuVO;

import java.util.List;

public interface SysMenuService {

    List<SysMenuVO> listMenus();

    List<SysMenuVO> listCurrentMenus(String roleCode);
}
