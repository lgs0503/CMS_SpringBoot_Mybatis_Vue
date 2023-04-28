package com.gs.bbs.api.banner.mapper;

import com.gs.bbs.api.banner.dto.BannerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    List<BannerDTO> getBannerList(BannerDTO bannerDTO);

    BannerDTO getBanner(int bannerId);

    int insertBanner(BannerDTO bannerDTO);

    int updateBanner(BannerDTO bannerDTO);

    int deleteBanner(List<Integer> bannerIds);

}
