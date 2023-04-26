package com.gs.bbs.api.like.service;

import com.gs.bbs.api.like.dto.LikeDTO;
import com.gs.bbs.api.like.mapper.LikeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LikeServiceImpl implements LikeService{

    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public List<LikeDTO> getLikeList(LikeDTO likeDTO) {
        return likeMapper.getLikeList(likeDTO);
    }

    @Override
    public LikeDTO getLike(int likeId) {
        return likeMapper.getLike(likeId);
    }

    @Override
    public int insertLike(LikeDTO likeDTO) {
        return likeMapper.insertLike(likeDTO);
    }

    @Override
    public int updateLike(LikeDTO likeDTO) {
        return likeMapper.updateLike(likeDTO);
    }

    @Override
    public int deleteLike(List<Integer> likeIds) {
        return likeMapper.deleteLike(likeIds);
    }
}
