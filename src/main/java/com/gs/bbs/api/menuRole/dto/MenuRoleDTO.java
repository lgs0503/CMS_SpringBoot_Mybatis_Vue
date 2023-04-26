package com.gs.bbs.api.menuRole.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuRoleDTO extends CommonDTO {

    private int roleId;
    private int menuId;
    private String selectYn;
    private String insertYn;
    private String updateYn;
    private String deleteYn;
    private String downloadYn;
    private String uploadYn;
    private String useYn;

}
