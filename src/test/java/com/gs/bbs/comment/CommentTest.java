package com.gs.bbs.comment;

import com.gs.bbs.api.comment.dto.CommentDTO;
import com.gs.bbs.api.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class CommentTest {

    private final CommentService commentService;

    @Autowired
    public CommentTest(CommentService commentService) {
        this.commentService = commentService;
    }

    @Test
    @Operation(summary = "댓글 리스트 조회")
    public void getCommentList() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUseYn("Y");

        commentService.getCommentList(commentDTO);
    }

    @Test
    @Operation(summary = "댓글 조회")
    public void getComment() {
        commentService.getComment(1);
    }

    @Test
    @Operation(summary = "댓글 추가")
    public void insertComment() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPostId(1);
        commentDTO.setTitle("코멘트 타이틀 테스트");
        commentDTO.setComment("코멘트");
        commentDTO.setCreateUser("Junit_Test");
        commentDTO.setUpperCommentId(14);

        commentService.insertComment(commentDTO);

        getCommentList();
    }

    @Test
    @Operation(summary = "댓글 수정")
    public void updateComment() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(15);
        commentDTO.setPostId(1);
        commentDTO.setTitle("코멘트 타이틀 테스트 수정123");
        commentDTO.setComment("코멘트  수정123");
        commentDTO.setUpdateUser("Junit_Test");
        commentDTO.setUpperCommentId(14);

        commentService.updateComment(commentDTO);

        getCommentList();
    }

    @Test
    @Operation(summary = "댓글 삭제")
    public void deleteComment() {

        List<Integer> commentIds = new ArrayList<Integer>();
        commentIds.add(12);
        commentIds.add(13);

        commentService.deleteComment(commentIds);

        getCommentList();
    }
}
