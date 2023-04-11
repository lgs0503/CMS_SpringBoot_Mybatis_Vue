package com.gs.bbs.api.groupCode.controller;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/groupCode")
public class GroupCodeController {

    @Autowired
    GroupCodeService groupCodeService;

    @GetMapping
    public List<GroupCodeDTO> getGroupCodeList(@RequestBody GroupCodeDTO groupCodeDTO) {

        return groupCodeService.getGroupCodeList(groupCodeDTO);
    }

    @GetMapping("/{groupCodeId}")
    public GroupCodeDTO getGroupCode(@PathVariable(value = "groupCodeId") int groupCodeId) {
        return groupCodeService.getGroupCode(groupCodeId);
    }

    @PostMapping
    public int insertGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeService.insertGroupCode(groupCodeDTO);
    }

    @PutMapping
    public int updateGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeService.updateGroupCode(groupCodeDTO);
    }

    @DeleteMapping
    public int deleteGroupCode(List<Integer> groupCodeId) {
        return groupCodeService.deleteGroupCode(groupCodeId);
    }
}
