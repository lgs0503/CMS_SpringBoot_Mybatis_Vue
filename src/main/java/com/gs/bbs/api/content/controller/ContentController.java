package com.gs.bbs.api.content.controller;

import com.gs.bbs.api.content.dto.ContentDTO;
import com.gs.bbs.api.content.serivce.ContentService;
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
@RequestMapping("/content")
@Slf4j
@Tag(name = "Content", description = "컨텐츠 Api")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    @Operation(summary = "컨텐츠 리스트 조회")
    public ResponseEntity<ResponseDto> getContentList(
            @RequestParam(value = "contentId", defaultValue = "0") int contentId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setContentId(contentId);
        contentDTO.setName(name);
        contentDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getContentList Success",
                        contentService.getContentList(contentDTO)
                )
        );
    }

    @GetMapping("/{contentId}")
    @Operation(summary = "컨텐츠 조회")
    public ResponseEntity<ResponseDto> getContent(@PathVariable int contentId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getContent Success",
                        contentService.getContent(contentId)
                )
        );
    }

    @PostMapping
    @Operation(summary = "컨텐츠 추가")
    public ResponseEntity<ResponseDto> insertContent(@RequestBody ContentDTO contentDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertContent Success",
                        contentService.insertContent(contentDTO)
                )
        );
    }

    @PutMapping
    @Operation(summary = "컨텐츠 수정")
    public ResponseEntity<ResponseDto> updateContent(@RequestBody ContentDTO contentDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateContent Success",
                        contentService.updateContent(contentDTO)
                )
        );
    }

    @DeleteMapping
    @Operation(summary = "컨텐츠 삭제")
    public ResponseEntity<ResponseDto> deleteContent(@RequestBody List<Integer> contentIds){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteContent Success",
                        contentService.deleteContent(contentIds)
                )
        );
    }


}
