package com.projectexample.librarymanagement.controller;

import com.projectexample.librarymanagement.common.ApiResponse;
import com.projectexample.librarymanagement.service.SysUserService;
import com.projectexample.librarymanagement.vo.SysUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/system/users")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping
    public ApiResponse<List<SysUserVO>> list() {
        return ApiResponse.success(sysUserService.listUsers());
    }
}
