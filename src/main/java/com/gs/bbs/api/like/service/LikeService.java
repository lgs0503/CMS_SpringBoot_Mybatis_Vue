package com.gs.bbs.api.like.service;

import com.gs.bbs.api.like.dto.LikeDTO;

import java.util.List;

public interface LikeService {

    List<LikeDTO> getLikeList(LikeDTO likeDTO);

    LikeDTO getLike(int likeId);

    int insertLike(LikeDTO likeDTO);

    int updateLike(LikeDTO likeDTO);

    int deleteLike(List<Integer> likeIds);

}
