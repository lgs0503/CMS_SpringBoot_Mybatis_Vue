package com.gs.bbs.api.comment.mapper;

import com.gs.bbs.api.comment.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDTO> getCommentList(CommentDTO commentDTO);

    CommentDTO getComment(int commentId);

    int insertComment(CommentDTO commentDTO);

    int updateComment(CommentDTO commentDTO);

    int deleteComment(List<Integer> commentIds);

}
