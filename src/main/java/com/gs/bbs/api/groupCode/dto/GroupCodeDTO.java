package com.gs.bbs.api.groupCode.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupCodeDTO extends CommonDTO {

    private int groupCodeId;
    private String name;
    private String korName;
    private String description;
    private String useYn;
    
}
