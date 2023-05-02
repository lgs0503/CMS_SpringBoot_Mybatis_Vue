package com.gs.bbs.content;

import com.gs.bbs.api.content.dto.ContentDTO;
import com.gs.bbs.api.content.serivce.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class ContentTest {

    private final ContentService contentService;

    @Autowired
    public ContentTest(ContentService contentService) {
        this.contentService = contentService;
    }

    @Test
    @DisplayName("컨텐츠 리스트 조회")
    public void getContentList() {
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setUseYn("Y");

        contentService.getContentList(contentDTO);
    }

    @Test
    @DisplayName("컨텐츠 조회")
    public void getContent() {
        contentService.getContent(1);
    }

    @Test
    @DisplayName("컨텐츠 추가")
    public void insertContent() {

        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setName("컨텐츠 제목");
        contentDTO.setContent("컨텐츠 내용");
        contentDTO.setFileId(1);
        contentDTO.setCreateUser("Junit_Test");

        contentService.insertContent(contentDTO);

        getContentList();
    }

    @Test
    @DisplayName("컨텐츠 수정")
    public void updateContent() {

        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setContentId(1);
        contentDTO.setName("컨텐츠 제목 수정");
        contentDTO.setContent("컨텐츠 내용 수정");
        contentDTO.setFileId(1);
        contentDTO.setUpdateUser("Junit_Test");

        contentService.updateContent(contentDTO);

        getContentList();
    }

    @Test
    @DisplayName("컨텐츠 삭제")
    public void deleteContent() {

        List<Integer> contentIds = new ArrayList<Integer>();

        contentIds.add(1);

        contentService.deleteContent(contentIds);

        getContentList();
    }
}
