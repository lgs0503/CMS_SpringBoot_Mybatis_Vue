package com.gs.bbs.api.like.mapper;

import com.gs.bbs.api.like.dto.LikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {

    List<LikeDTO> getLikeList(LikeDTO likeDTO);

    LikeDTO getLike(int likeId);

    int insertLike(LikeDTO likeDTO);

    int updateLike(LikeDTO likeDTO);

    int deleteLike(List<Integer> likeIds);

}
