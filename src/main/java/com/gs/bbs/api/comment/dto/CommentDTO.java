package com.gs.bbs.api.comment.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO extends CommonDTO {

    private int commentId;
    private int postId;
    private String title;
    private String comment;
    private int upperCommentId;
    private String useYn;

}
