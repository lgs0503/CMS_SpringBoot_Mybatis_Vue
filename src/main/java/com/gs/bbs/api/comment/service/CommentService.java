package com.gs.bbs.api.comment.service;

import com.gs.bbs.api.comment.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getCommentList(CommentDTO commentDTO);

    CommentDTO getComment(int commentId);

    int insertComment(CommentDTO commentDTO);

    int updateComment(CommentDTO commentDTO);

    int deleteComment(List<Integer> commentIds);

}
