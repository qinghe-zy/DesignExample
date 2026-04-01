package com.projectexample.studentmanagement.service;

import com.projectexample.studentmanagement.dto.LoginRequest;
import com.projectexample.studentmanagement.vo.AuthTokenVO;
import com.projectexample.studentmanagement.vo.CurrentUserVO;

public interface AuthService {

    AuthTokenVO login(LoginRequest request);

    CurrentUserVO currentUser(String username);
}

