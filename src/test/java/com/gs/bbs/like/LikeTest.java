package com.gs.bbs.like;

import com.gs.bbs.api.like.dto.LikeDTO;
import com.gs.bbs.api.like.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class LikeTest {

    private final LikeService likeService;

    @Autowired
    public LikeTest(LikeService likeService) {
        this.likeService = likeService;
    }

    @Test
    @DisplayName("좋아요 리스트 조회")
    public void getLikeList() {
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setUseYn("Y");

        likeService.getLikeList(likeDTO);
    }

    @Test
    @DisplayName("좋아요 조회")
    public void getLike() {
        likeService.getLike(1);
    }

    @Test
    @DisplayName("좋아요 추가")
    public void insertLike() {

        LikeDTO likeDTOPost = new LikeDTO();
        likeDTOPost.setType("LT001");
        likeDTOPost.setPostId(1);
        likeDTOPost.setCreateUser("Junit_Test1");

        likeService.insertLike(likeDTOPost);


        LikeDTO likeDTOComment = new LikeDTO();
        likeDTOComment.setType("LT002");
        likeDTOComment.setCommentId(2);
        likeDTOComment.setCreateUser("Junit_Test1");

        likeService.insertLike(likeDTOComment);

        getLikeList();
    }

    @Test
    @DisplayName("좋아요 수정")
    public void updateLike() {

        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setLikeId(4);
        likeDTO.setType("LT001");
        likeDTO.setUseYn("Y"); //삭제된경우 신규를 추가하지 않고 수정으로 다시 좋아요를 누른다.
        likeDTO.setPostId(1);
        likeDTO.setCreateUser("Junit_Test1");

        likeService.updateLike(likeDTO);

        getLikeList();
    }

    @Test
    @DisplayName("좋아요 삭제")
    public void deleteLike() {

        List<Integer> likeIds = new ArrayList<Integer>();

        likeIds.add(3);
        likeIds.add(4);

        likeService.deleteLike(likeIds);

        getLikeList();
    }
}
