package com.gs.bbs.api.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDTO {
    private String userId;
    private String password;
}
