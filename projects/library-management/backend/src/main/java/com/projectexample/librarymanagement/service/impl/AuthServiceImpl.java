package com.projectexample.librarymanagement.service.impl;

import com.projectexample.librarymanagement.dto.LoginRequest;
import com.projectexample.librarymanagement.entity.SysUser;
import com.projectexample.librarymanagement.exception.BusinessException;
import com.projectexample.librarymanagement.security.JwtTokenProvider;
import com.projectexample.librarymanagement.service.AuthService;
import com.projectexample.librarymanagement.service.SysUserService;
import com.projectexample.librarymanagement.vo.AuthTokenVO;
import com.projectexample.librarymanagement.vo.CurrentUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthTokenVO login(LoginRequest request) {
        SysUser user = sysUserService.findByUsername(request.getUsername());
        if (user == null || user.getStatus() == null || user.getStatus() != 1) {
            throw new BusinessException("Invalid username or password");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException("Invalid username or password");
        }

        CurrentUserVO currentUser = CurrentUserVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .roleCode(user.getRoleCode())
                .build();
        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getNickname(), user.getRoleCode());
        return new AuthTokenVO(token, currentUser);
    }

    @Override
    public CurrentUserVO currentUser(String username) {
        SysUser user = sysUserService.findByUsername(username);
        if (user == null) {
            throw new BusinessException(4010, "User session is invalid");
        }
        return CurrentUserVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .roleCode(user.getRoleCode())
                .build();
    }
}
