package com.gs.bbs.api.banner.service;

import com.gs.bbs.api.banner.dto.BannerDTO;

import java.util.List;

public interface BannerService {

    List<BannerDTO> getBannerList(BannerDTO bannerDTO);

    BannerDTO getBanner(int bannerId);

    int insertBanner(BannerDTO bannerDTO);

    int updateBanner(BannerDTO bannerDTO);

    int deleteBanner(List<Integer> bannerIds);

}
