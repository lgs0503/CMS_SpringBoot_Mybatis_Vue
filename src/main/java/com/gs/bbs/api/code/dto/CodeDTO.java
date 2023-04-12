package com.gs.bbs.api.code.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CodeDTO extends CommonDTO {

    private int codeId;
    private int groupCodeId;
    private String useYn;
    private int sort;

}
