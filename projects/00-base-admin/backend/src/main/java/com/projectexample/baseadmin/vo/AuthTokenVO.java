package com.projectexample.baseadmin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthTokenVO {

    private String token;
    private CurrentUserVO currentUser;
}
