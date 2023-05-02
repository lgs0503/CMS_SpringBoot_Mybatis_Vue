package com.gs.bbs.api.content.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContentDTO extends CommonDTO {

    private int contentId;
    private String name;
    private String content;
    private String useYn;
    private int fileId;

}
