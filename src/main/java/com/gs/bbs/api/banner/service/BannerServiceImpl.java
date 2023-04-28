package com.gs.bbs.api.banner.service;

import com.gs.bbs.api.banner.dto.BannerDTO;
import com.gs.bbs.api.banner.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private final BannerMapper bannerMapper;

    @Autowired
    public BannerServiceImpl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<BannerDTO> getBannerList(BannerDTO bannerDTO) {
        return bannerMapper.getBannerList(bannerDTO);
    }

    @Override
    public BannerDTO getBanner(int bannerId) {
        return bannerMapper.getBanner(bannerId);
    }

    @Override
    public int insertBanner(BannerDTO bannerDTO) {
        return bannerMapper.insertBanner(bannerDTO);
    }

    @Override
    public int updateBanner(BannerDTO bannerDTO) {
        return bannerMapper.updateBanner(bannerDTO);
    }

    @Override
    public int deleteBanner(List<Integer> bannerIds) {
        return bannerMapper.deleteBanner(bannerIds);
    }
}
