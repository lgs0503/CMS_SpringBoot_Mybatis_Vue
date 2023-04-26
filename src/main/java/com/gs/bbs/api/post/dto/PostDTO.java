package com.gs.bbs.api.post.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO extends CommonDTO {

    private int postId;
    private int boardId;
    private String title;
    private String content;
    private String useYn;
    private String fileYn;
    private int viewCnt;
    private int fileId;

}
