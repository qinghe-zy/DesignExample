package com.projectexample.baseadmin.service;

import com.projectexample.baseadmin.dto.LoginRequest;
import com.projectexample.baseadmin.vo.AuthTokenVO;
import com.projectexample.baseadmin.vo.CurrentUserVO;

public interface AuthService {

    AuthTokenVO login(LoginRequest request);

    CurrentUserVO currentUser(String username);
}
