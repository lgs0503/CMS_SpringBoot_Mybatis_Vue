package com.gs.bbs.api.banner.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO extends CommonDTO {

    private int bannerId;
    private String type;
    private int fileId;
    private int contentId;
    private String useYn;
    private int sort;

}
