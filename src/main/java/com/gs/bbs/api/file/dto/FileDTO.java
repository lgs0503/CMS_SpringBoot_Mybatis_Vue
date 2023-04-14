package com.gs.bbs.api.file.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO extends CommonDTO {

    private int fileId;
    private int masterFileId;
    private String name;
    private String uuidName;
    private String path;
    private int size;
    private String exten;
    private int sort;

}
