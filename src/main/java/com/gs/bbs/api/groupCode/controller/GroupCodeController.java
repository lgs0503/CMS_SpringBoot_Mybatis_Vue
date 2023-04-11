package com.gs.bbs.api.groupCode.controller;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "GroupCode", description = "그룹코드 api")
@RestController
@RequestMapping(value = "/groupCode")
public class GroupCodeController {

    @Autowired
    GroupCodeService groupCodeService;

    @Operation(summary = "그룹코드 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getGroupCodeList(@RequestBody GroupCodeDTO groupCodeDTO) {

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                "getGroupCodeList Success",
                        groupCodeService.getGroupCodeList(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 단건 조회")
    @GetMapping("/{groupCodeId}")
    public ResponseEntity<ResponseDto> getGroupCode(@PathVariable(value = "groupCodeId") int groupCodeId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.getGroupCode(groupCodeId)
                )
        );
    }

    @Operation(summary = "그룹코드 등록")
    @PostMapping
    public ResponseEntity<ResponseDto> insertGroupCode(GroupCodeDTO groupCodeDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.insertGroupCode(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updateGroupCode(GroupCodeDTO groupCodeDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.updateGroupCode(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteGroupCode(List<Integer> groupCodeId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.deleteGroupCode(groupCodeId)
                )
        );
    }
}
