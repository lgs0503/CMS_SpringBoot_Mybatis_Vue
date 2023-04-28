package com.gs.bbs.api.like.dto;

import com.gs.bbs.util.CommonDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeDTO extends CommonDTO {

    private int likeId;
    private String type;
    private int postId;
    private int commentId;
    private String useYn;

}
