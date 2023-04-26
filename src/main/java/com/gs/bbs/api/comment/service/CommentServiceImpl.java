package com.gs.bbs.api.comment.service;

import com.gs.bbs.api.comment.dto.CommentDTO;
import com.gs.bbs.api.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDTO> getCommentList(CommentDTO commentDTO) {
        return commentMapper.getCommentList(commentDTO);
    }

    @Override
    public CommentDTO getComment(int commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public int insertComment(CommentDTO commentDTO) {
        return commentMapper.insertComment(commentDTO);
    }

    @Override
    public int updateComment(CommentDTO commentDTO) {
        return commentMapper.updateComment(commentDTO);
    }

    @Override
    public int deleteComment(List<Integer> commentIds) {
        return commentMapper.deleteComment(commentIds);
    }
}
