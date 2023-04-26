package com.gs.bbs.api.board.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDto extends CommonDTO {

    private int boardId;
    private String name;
    private String type;
    private String useYn;

}
