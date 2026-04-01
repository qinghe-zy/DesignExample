package com.projectexample.baseadmin.service;

import com.projectexample.baseadmin.vo.SysMenuVO;

import java.util.List;

public interface SysMenuService {

    List<SysMenuVO> listMenus();

    List<SysMenuVO> listCurrentMenus(String roleCode);
}
