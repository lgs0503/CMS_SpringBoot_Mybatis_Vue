package com.gs.bbs.api.menu.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuDTO extends CommonDTO {

    private int menuId;
    private String name;
    private int upperMenuId;
    private String type;
    private int boardId;
    private int contentId;
    private String url;
    private String useYn;
    private int sort;

}
