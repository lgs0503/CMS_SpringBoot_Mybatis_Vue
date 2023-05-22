package com.gs.bbs.api.role.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDTO extends CommonDTO {

    private int roleId;
    private String name;
    private String description;
    private String useYn;

}
