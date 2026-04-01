package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.dto.LoginRequest;
import com.projectexample.librarymanagement.vo.AuthTokenVO;
import com.projectexample.librarymanagement.vo.CurrentUserVO;

public interface AuthService {

    AuthTokenVO login(LoginRequest request);

    CurrentUserVO currentUser(String username);
}
