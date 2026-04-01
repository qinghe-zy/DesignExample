package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.entity.SysRole;
import com.projectexample.studentmanagement.mapper.SysRoleMapper;
import com.projectexample.studentmanagement.service.SysRoleService;
import com.projectexample.studentmanagement.vo.SysRoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleVO> listRoles() {
        return sysRoleMapper.selectList(Wrappers.lambdaQuery(SysRole.class)
                        .orderByAsc(SysRole::getId))
                .stream()
                .map(role -> SysRoleVO.builder()
                        .id(role.getId())
                        .roleCode(role.getRoleCode())
                        .roleName(role.getRoleName())
                        .remark(role.getRemark())
                        .build())
                .toList();
    }
}

