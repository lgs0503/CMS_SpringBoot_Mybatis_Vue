package com.gs.bbs.api.popup.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PopupDTO extends CommonDTO {

    private int popupId;
    private String name;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int zIndex;
    private String type;
    private int fileId;
    private int contentId;
    private String useYn;

}
