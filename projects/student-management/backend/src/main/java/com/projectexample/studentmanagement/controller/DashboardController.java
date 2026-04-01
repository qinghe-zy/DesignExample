package com.projectexample.studentmanagement.controller;

import com.projectexample.studentmanagement.common.ApiResponse;
import com.projectexample.studentmanagement.service.DashboardService;
import com.projectexample.studentmanagement.vo.DashboardOverviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/overview")
    public ApiResponse<DashboardOverviewVO> overview() {
        return ApiResponse.success(dashboardService.getOverview());
    }
}

