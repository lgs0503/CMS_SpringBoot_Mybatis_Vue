package com.gs.bbs.api.popup.controller;

import com.gs.bbs.api.popup.dto.PopupDTO;
import com.gs.bbs.api.popup.service.PopupService;
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
@RequestMapping("/popup")
@Slf4j
@Tag(name = "Popup", description = "팝업 Api")
public class PopupController {

    private final PopupService popupService;

    @Autowired
    public PopupController(PopupService popupService) {
        this.popupService = popupService;
    }

    @GetMapping
    @Operation(summary = "팝업 리스트 조회")
    public ResponseEntity<ResponseDTO> getPopupList(
            @RequestParam(value = "popupId", defaultValue = "0") int popupId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        PopupDTO popupDTO = new PopupDTO();
        popupDTO.setPopupId(popupId);
        popupDTO.setName(name);
        popupDTO.setType(type);
        popupDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getPopupList Success",
                        popupService.getPopupList(popupDTO)
                )
        );
    }

    @GetMapping("/{popupId}")
    @Operation(summary = "팝업 조회")
    public ResponseEntity<ResponseDTO> getPopup(@PathVariable int popupId) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getPopup Success",
                        popupService.getPopup(popupId)
                )
        );
    }

    @PostMapping
    @Operation(summary = "팝업 추가")
    public ResponseEntity<ResponseDTO> insertPopup(@RequestBody PopupDTO popupDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertPopup Success",
                        popupService.insertPopup(popupDTO)
                )
        );
    }

    @PutMapping
    @Operation(summary = "팝업 수정")
    public ResponseEntity<ResponseDTO> updatePopup(@RequestBody PopupDTO popupDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updatePopup Success",
                        popupService.updatePopup(popupDTO)
                )
        );
    }

    @DeleteMapping
    @Operation(summary = "팝업 삭제")
    public ResponseEntity<ResponseDTO> deletePopup(@RequestBody List<Integer> popupIds) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deletePopup Success",
                        popupService.deletePopup(popupIds)
                )
        );
    }
}
