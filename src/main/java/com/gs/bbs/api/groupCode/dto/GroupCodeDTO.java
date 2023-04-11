package com.gs.bbs.api.groupCode.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupCodeDTO {

    public int groupCodeId;
    public String name;
    public String useYn;
    public String createUser;
    public Date createDate;
    public String updateUser;
    public Date updateDate;

}
