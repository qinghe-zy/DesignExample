package com.projectexample.baseadmin.service.impl;

import com.projectexample.baseadmin.mapper.NoticeMapper;
import com.projectexample.baseadmin.mapper.SysMenuMapper;
import com.projectexample.baseadmin.mapper.SysRoleMapper;
import com.projectexample.baseadmin.mapper.SysUserMapper;
import com.projectexample.baseadmin.service.DashboardService;
import com.projectexample.baseadmin.vo.DashboardMetricVO;
import com.projectexample.baseadmin.vo.DashboardOverviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysMenuMapper sysMenuMapper;
    private final NoticeMapper noticeMapper;

    @Override
    public DashboardOverviewVO getOverview() {
        return DashboardOverviewVO.builder()
                .headline("Base admin baseline is ready for extension")
                .summary("Use this project as the current shared starting point for management-heavy academic systems.")
                .metrics(List.of(
                        new DashboardMetricVO("Users", sysUserMapper.selectCount(null), "Seed system users"),
                        new DashboardMetricVO("Roles", sysRoleMapper.selectCount(null), "Current RBAC roles"),
                        new DashboardMetricVO("Menus", sysMenuMapper.selectCount(null), "Navigation and permission nodes"),
                        new DashboardMetricVO("Notices", noticeMapper.selectCount(null), "Representative CRUD records")
                ))
                .nextActions(List.of(
                        "Reuse the auth and dashboard baseline for future templates.",
                        "Add topic-specific modules incrementally instead of rewriting the base.",
                        "Promote repeated patterns into shared assets when they stabilize."
                ))
                .build();
    }
}
