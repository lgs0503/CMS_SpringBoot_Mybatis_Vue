package com.gs.bbs.api.post.service;

import com.gs.bbs.api.post.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getPostList(PostDTO postDTO);

    PostDTO getPost(int postId);

    int insertPost(PostDTO postDTO);

    int updatePost(PostDTO postDTO);

    int deletePost(List<Integer> postIds);
}
