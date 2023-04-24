package com.gs.bbs.api.post.service;

import com.gs.bbs.api.post.dto.PostDTO;
import com.gs.bbs.api.post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDTO> getPostList(PostDTO postDTO) {
        return postMapper.getPostList(postDTO);
    }

    @Override
    public PostDTO getPost(int postId) {
        return postMapper.getPost(postId);
    }

    @Override
    public int insertPost(PostDTO postDTO) {
        return postMapper.insertPost(postDTO);
    }

    @Override
    public int updatePost(PostDTO postDTO) {
        return postMapper.updatePost(postDTO);
    }

    @Override
    public int deletePost(List<Integer> postIds) {
        return postMapper.deletePost(postIds);
    }
}
