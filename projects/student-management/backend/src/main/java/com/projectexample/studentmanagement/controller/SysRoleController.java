package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.service.SysRoleService;
import com.projectexample.studentmanagement.vo.SysRoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/system/roles")
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @GetMapping
    public ApiResponse<List<SysRoleVO>> list() {
        return ApiResponse.success(sysRoleService.listRoles());
    }
}

