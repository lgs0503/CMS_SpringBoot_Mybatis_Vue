package com.gs.bbs.api.comment.controller;

import com.gs.bbs.api.comment.dto.CommentDTO;
import com.gs.bbs.api.comment.service.CommentService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@Slf4j
@Tag(name = "Comment", description = "댓글 Api")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "댓글 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getCommentList(
            @RequestParam(value = "commentId", defaultValue = "0") int commentId,
            @RequestParam(value = "postId", defaultValue = "0") int postId,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "createUser", defaultValue = "") String createUser,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentId);
        commentDTO.setPostId(postId);
        commentDTO.setTitle(title);
        commentDTO.setCreateUser(createUser);
        commentDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getCommentList Success",
                        commentService.getCommentList(commentDTO)
                )
        );
    }

    @Operation(summary = "댓글 조회")
    @GetMapping("/{commentId}")
    public ResponseEntity<ResponseDto> getComment(@PathVariable int commentId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getComment Success",
                        commentService.getComment(commentId)
                )
        );
    }

    @Operation(summary = "댓글 추가")
    @PostMapping
    public ResponseEntity<ResponseDto> insertComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertComment Success",
                        commentService.insertComment(commentDTO)
                )
        );
    }

    @Operation(summary = "댓글 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updateComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateComment Success",
                        commentService.updateComment(commentDTO)
                )
        );
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteComment(@RequestBody List<Integer> commentIds){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteComment Success",
                        commentService.deleteComment(commentIds)
                )
        );
    }
}
