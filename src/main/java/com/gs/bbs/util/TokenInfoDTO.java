package com.gs.bbs.util;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfoDTO {

    private String grantType;
    private String accessToken;
    private String refreshToken;

}