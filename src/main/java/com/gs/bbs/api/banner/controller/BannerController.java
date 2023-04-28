package com.gs.bbs.api.banner.controller;

import com.gs.bbs.api.banner.dto.BannerDTO;
import com.gs.bbs.api.banner.service.BannerService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
@Tag(name = "Banner", description = "배너 Api")
@Slf4j
public class BannerController {

    private final BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @Operation(summary = "배너 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getBannerList(
            @RequestParam(value = "bannerId", defaultValue = "0") int bannerId,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setBannerId(bannerId);
        bannerDTO.setType(type);
        bannerDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getBannerList Success",
                        bannerService.getBannerList(bannerDTO)
                )
        );
    }

    @Operation(summary = "배너 조회")
    @GetMapping("/{bannerId}")
    public ResponseEntity<ResponseDto> getBanner(@PathVariable("bannerId") int bannerId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getBanner Success",
                        bannerService.getBanner(bannerId)
                )
        );
    }

    @Operation(summary = "배너 추가")
    @PostMapping
    public ResponseEntity<ResponseDto> insertBanner(@RequestBody BannerDTO bannerDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertBanner Success",
                        bannerService.insertBanner(bannerDTO)
                )
        );
    }

    @Operation(summary = "배너 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updaterBanner(@RequestBody BannerDTO bannerDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updaterBanner Success",
                        bannerService.updateBanner(bannerDTO)
                )
        );
    }

    @Operation(summary = "배너 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteBanner(@RequestBody List<Integer> bannerIds){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteBanner Success",
                        bannerService.deleteBanner(bannerIds)
                )
        );
    }
}
