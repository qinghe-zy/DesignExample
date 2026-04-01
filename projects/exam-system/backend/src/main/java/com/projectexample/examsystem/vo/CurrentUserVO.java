package com.projectexample.examsystem.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentUserVO {

    private Long id;
    private String username;
    private String nickname;
    private String roleCode;
}
