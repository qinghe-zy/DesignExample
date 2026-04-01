package com.projectexample.studentmanagement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.projectexample.studentmanagement.entity.SysUser;
import com.projectexample.studentmanagement.mapper.SysUserMapper;
import com.projectexample.studentmanagement.service.SysUserService;
import com.projectexample.studentmanagement.vo.SysUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class)
                .eq(SysUser::getUsername, username)
                .last("limit 1"));
    }

    @Override
    public List<SysUserVO> listUsers() {
        return sysUserMapper.selectList(Wrappers.lambdaQuery(SysUser.class)
                        .orderByAsc(SysUser::getId))
                .stream()
                .map(user -> SysUserVO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .nickname(user.getNickname())
                        .roleCode(user.getRoleCode())
                        .status(user.getStatus())
                        .build())
                .toList();
    }
}

