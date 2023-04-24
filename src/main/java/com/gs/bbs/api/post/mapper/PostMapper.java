package com.gs.bbs.api.post.mapper;


import com.gs.bbs.api.post.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostDTO> getPostList(PostDTO postDTO);

    PostDTO getPost(int postId);

    int insertPost(PostDTO postDTO);

    int updatePost(PostDTO postDTO);

    int deletePost(List<Integer> postIds);

}
