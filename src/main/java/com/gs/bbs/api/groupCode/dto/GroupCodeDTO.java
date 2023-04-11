package com.gs.bbs.api.groupCode.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupCodeDTO extends CommonDTO {

    public int groupCodeId;
    public String name;
    public String useYn;
    
}
