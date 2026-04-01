package com.projectexample.librarymanagement.controller;

import com.projectexample.librarymanagement.common.ApiResponse;
import com.projectexample.librarymanagement.dto.LoginRequest;
import com.projectexample.librarymanagement.security.UserPrincipal;
import com.projectexample.librarymanagement.service.AuthService;
import com.projectexample.librarymanagement.vo.AuthTokenVO;
import com.projectexample.librarymanagement.vo.CurrentUserVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthTokenVO> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success(authService.login(request));
    }

    @GetMapping("/me")
    public ApiResponse<CurrentUserVO> currentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ApiResponse.success(authService.currentUser(userPrincipal.getUsername()));
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout() {
        return ApiResponse.success("logout success", null);
    }
}
