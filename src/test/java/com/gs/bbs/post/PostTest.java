package com.gs.bbs.post;

import com.gs.bbs.api.post.dto.PostDTO;
import com.gs.bbs.api.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PostTest {

    private final PostService postService;

    @Autowired
    public PostTest(PostService postService) {
        this.postService = postService;
    }

    @Test
    @DisplayName("게시글 리스트 조회")
    public void getPostList() {
        PostDTO postDTO = new PostDTO();
        postDTO.setUseYn("Y");

        postService.getPostList(postDTO);
    }

    @Test
    @DisplayName("게시글 조회")
    public void getPost() {
        postService.getPost(1);
    }

    @Test
    @DisplayName("게시글 추가")
    public void insertPost() {
        PostDTO postDTO = new PostDTO();
        postDTO.setBoardId(1);
        postDTO.setTitle("테스트 제목");
        postDTO.setContent("테스트 글");
        postDTO.setFileYn("Y");
        postDTO.setFileId(0);
        postDTO.setCreateUser("Junit_Test");

        postService.insertPost(postDTO);

        getPostList();
    }

    @Test
    @DisplayName("게시글 수정")
    public void updatePost() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(1);
        postDTO.setBoardId(1);
        postDTO.setTitle("테스트 제목 수정");
        postDTO.setContent("테스트 글 수정");
        postDTO.setFileYn("Y");
        postDTO.setFileId(0);
        postDTO.setUpdateUser("Junit_Test");

        postService.updatePost(postDTO);

        getPostList();

    }

    @Test
    @DisplayName("게시글 삭제")
    public void deletePost() {
        List<Integer> postIds = new ArrayList<Integer>();
        postIds.add(1);

        postService.deletePost(postIds);

        getPostList();
    }
}
