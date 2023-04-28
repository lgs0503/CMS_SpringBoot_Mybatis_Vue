package com.gs.bbs.api.like.controller;

import com.gs.bbs.api.like.dto.LikeDTO;
import com.gs.bbs.api.like.service.LikeService;
import com.gs.bbs.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@Slf4j
@Tag(name = "Like", description = "좋아요 Api")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(summary = "좋아요 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDTO> getLikeList(
            @RequestParam(value = "likeId", defaultValue = "0") int likeId,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setLikeId(likeId);
        likeDTO.setType(type);
        likeDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getLikeList Success",
                        likeService.getLikeList(likeDTO)
                )
        );
    }

    @Operation(summary = "좋아요 조회")
    @GetMapping("/{likeId}")
    public ResponseEntity<ResponseDTO> getLike(@PathVariable("likeId") int likeId) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getLike Success",
                        likeService.getLike(likeId)
                )
        );
    }

    @Operation(summary = "좋아요 추가")
    @PostMapping
    public ResponseEntity<ResponseDTO> insertLike(@RequestBody LikeDTO likeDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertLike Success",
                        likeService.insertLike(likeDTO)
                )
        );
    }

    @Operation(summary = "좋아요 수정")
    @PutMapping
    public ResponseEntity<ResponseDTO> updateLike(@RequestBody LikeDTO likeDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updateLike Success",
                        likeService.updateLike(likeDTO)
                )
        );
    }

    @Operation(summary = "좋아요 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteLike(@RequestBody List<Integer> likeIds) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deleteLike Success",
                        likeService.deleteLike(likeIds)
                )
        );
    }
}
