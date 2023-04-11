package com.gs.bbs.api.groupCode.controller;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<GroupCodeDTO> getGroupCodeList(@RequestBody GroupCodeDTO groupCodeDTO) {

        return groupCodeService.getGroupCodeList(groupCodeDTO);
    }

    @Operation(summary = "그룹코드 단건 조회")
    @GetMapping("/{groupCodeId}")
    public GroupCodeDTO getGroupCode(@PathVariable(value = "groupCodeId") int groupCodeId) {
        return groupCodeService.getGroupCode(groupCodeId);
    }

    @Operation(summary = "그룹코드 등록")
    @PostMapping
    public int insertGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeService.insertGroupCode(groupCodeDTO);
    }

    @Operation(summary = "그룹코드 수정")
    @PutMapping
    public int updateGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeService.updateGroupCode(groupCodeDTO);
    }

    @Operation(summary = "그룹코드 삭제")
    @DeleteMapping
    public int deleteGroupCode(List<Integer> groupCodeId) {
        return groupCodeService.deleteGroupCode(groupCodeId);
    }
}
