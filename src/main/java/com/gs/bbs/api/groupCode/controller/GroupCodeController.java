package com.gs.bbs.api.groupCode.controller;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import com.gs.bbs.util.ResponseDto;
import com.gs.bbs.util.StringUtil;
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
@RequestMapping("/groupCode")
public class GroupCodeController {

    private final GroupCodeService groupCodeService;

    @Autowired
    public GroupCodeController(GroupCodeService groupCodeService) {
        this.groupCodeService = groupCodeService;
    }

    @Operation(summary = "그룹코드 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getGroupCodeList(
            @RequestParam(value = "groupCodeId", defaultValue = "0") String groupCodeId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        GroupCodeDTO groupCodeDTO = new GroupCodeDTO();

        if (StringUtil.isNotEmpty(groupCodeId))
            groupCodeDTO.setGroupCodeId(Integer.parseInt(groupCodeId));

        groupCodeDTO.setName(name);
        groupCodeDTO.setUseYn(useYn);

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
    public ResponseEntity<ResponseDto> getGroupCode(@PathVariable("groupCodeId") int groupCodeId) {
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
    public ResponseEntity<ResponseDto> insertGroupCode(@RequestBody GroupCodeDTO groupCodeDTO) {
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
    public ResponseEntity<ResponseDto> updateGroupCode(@RequestBody GroupCodeDTO groupCodeDTO) {
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
    public ResponseEntity<ResponseDto> deleteGroupCode(@RequestBody List<Integer> groupCodeId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.deleteGroupCode(groupCodeId)
                )
        );
    }
}
