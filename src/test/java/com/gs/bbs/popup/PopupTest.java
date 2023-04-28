package com.gs.bbs.popup;

import com.gs.bbs.api.popup.dto.PopupDTO;
import com.gs.bbs.api.popup.service.PopupService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PopupTest {

    private final PopupService popupService;

    @Autowired
    public PopupTest(PopupService popupService) {
        this.popupService = popupService;
    }

    @DisplayName("팝업 리스트 조회")
    @Test
    public void getPopupList() {

        PopupDTO popupDTO = new PopupDTO();
        popupDTO.setUseYn("Y");

        popupService.getPopupList(popupDTO);

    }

    @DisplayName("팝업 조회")
    @Test
    public void getPopup() {
        popupService.getPopup(1);
    }

    @DisplayName("팝업 추가")
    @Test
    public void insertPopup() {

        PopupDTO popupDTO = new PopupDTO();
        popupDTO.setType("PT001");
        popupDTO.setName("팝업 타이틀");
        popupDTO.setXPos(50);
        popupDTO.setYPos(100);
        popupDTO.setWidth(200);
        popupDTO.setHeight(300);
        popupDTO.setZIndex(100);
        popupDTO.setFileId(1);
        popupDTO.setCreateUser("Junit_Test");

        popupService.insertPopup(popupDTO);

        getPopupList();

    }

    @DisplayName("팝업 수정")
    @Test
    public void updatePopup() {

        PopupDTO popupDTO = new PopupDTO();
        popupDTO.setPopupId(1);
        popupDTO.setType("PT001");
        popupDTO.setName("팝업 타이틀 수정");
        popupDTO.setXPos(60);
        popupDTO.setYPos(110);
        popupDTO.setWidth(210);
        popupDTO.setHeight(310);
        popupDTO.setZIndex(110);
        popupDTO.setFileId(1);
        popupDTO.setCreateUser("Junit_Test");

        popupService.updatePopup(popupDTO);

        getPopupList();

    }

    @DisplayName("팝업 삭제")
    @Test
    public void deletePopup() {

        List<Integer> popupIds = new ArrayList<Integer>();
        popupIds.add(1);

        popupService.deletePopup(popupIds);

        getPopupList();

    }
}
