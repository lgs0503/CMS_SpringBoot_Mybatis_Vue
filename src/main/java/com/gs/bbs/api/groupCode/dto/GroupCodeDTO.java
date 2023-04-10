package com.gs.bbs.api.groupCode.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroupCodeDTO {

    public int groupCodeId;
    public String name;
    public String useYn;
    public String createUser;
    public Date createDate;
    public String updateUser;
    public Date updateDate;

}
