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
    private String groupCodeName;
    private String name;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;
    private String useYn;
    private int sort;

}
