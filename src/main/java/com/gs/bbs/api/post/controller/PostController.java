package com.gs.bbs.api.post.controller;

import com.gs.bbs.api.post.dto.PostDTO;
import com.gs.bbs.api.post.service.PostService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Tag(name = "Post", description = "게시글 api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @Operation(summary = "게시글 리스트 조회")
    public ResponseEntity<ResponseDto> getPostList(
            @RequestParam(value = "postId", defaultValue = "0") int postId,
            @RequestParam(value = "boardId", defaultValue = "0") int boardId,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postId);
        postDTO.setBoardId(boardId);
        postDTO.setTitle(title);
        postDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getPostList Success",
                        postService.getPostList(postDTO)
                )
        );
    }

    @GetMapping("/{postId}")
    @Operation(summary = "게시글 조회")
    public ResponseEntity<ResponseDto> getList(@PathVariable("postId") int postId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getList Success",
                        postService.getPost(postId)
                )
        );
    }

    @PostMapping
    @Operation(summary = "게시글 추가")
    public ResponseEntity<ResponseDto> insertPost(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertPost Success",
                        postService.insertPost(postDTO)
                )
        );
    }

    @PatchMapping("/{postId}")
    @Operation(summary = "조회수 1 증가")
    public ResponseEntity<ResponseDto> updateViewCount(@PathVariable("postId") int postId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateViewCount Success",
                        postService.updateViewCount(postId)
                )
        );
    }

    @PutMapping
    @Operation(summary = "게시글 수정")
    public ResponseEntity<ResponseDto> updatePost(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updatePost Success",
                        postService.updatePost(postDTO)
                )
        );
    }

    @DeleteMapping
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<ResponseDto> deletePost(@RequestBody List<Integer> postIds){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deletePost Success",
                        postService.deletePost(postIds)
                )
        );
    }
}
