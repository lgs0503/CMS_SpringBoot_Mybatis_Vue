package com.gs.bbs.api.user.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO extends CommonDTO {

    private int userNo;
    private String userId;
    private String password;
    private String korName;
    private String engName;
    private String birthday;
    private String gender;
    private String address;
    private String addressDtl;
    private String phoneNum;
    private String email;
    private String useYn;
    private int fileId;

    private int roleId;
    private int roleName;

}
