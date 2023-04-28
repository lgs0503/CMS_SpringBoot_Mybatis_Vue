package com.gs.bbs.banner;

import com.gs.bbs.api.banner.dto.BannerDTO;
import com.gs.bbs.api.banner.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class BannerTest {

    private final BannerService bannerService;

    @Autowired
    public BannerTest(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @DisplayName("배너 리스트 조회")
    @Test
    public void getBannerList() {

        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setUseYn("Y");

        bannerService.getBannerList(bannerDTO);

    }

    @DisplayName("배너 조회")
    @Test
    public void getBanner() {

        bannerService.getBanner(1);

    }

    @DisplayName("배너 추가")
    @Test
    public void insertBanner() {

        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setType("BT001");
        bannerDTO.setFileId(1);
        bannerDTO.setSort(1);
        bannerDTO.setCreateUser("Junit_Test");

        bannerService.insertBanner(bannerDTO);

        getBannerList();
    }

    @DisplayName("배너 수정")
    @Test
    public void updateBanner() {

        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setBannerId(1);
        bannerDTO.setType("BT001");
        bannerDTO.setFileId(1);
        bannerDTO.setSort(2);
        bannerDTO.setCreateUser("Junit_Test");

        bannerService.updateBanner(bannerDTO);

        getBannerList();
    }

    @DisplayName("배너 삭제")
    @Test
    public void deleteBanner() {

        List<Integer> bannerIds = new ArrayList<Integer>();

        bannerIds.add(1);

        bannerService.deleteBanner(bannerIds);

        getBannerList();
    }
}
