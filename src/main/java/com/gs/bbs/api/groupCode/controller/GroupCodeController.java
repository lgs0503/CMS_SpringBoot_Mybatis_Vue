package com.gs.bbs.api.groupCode.controller;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.service.GroupCodeService;
import com.gs.bbs.util.ResponseDTO;
import com.gs.bbs.util.SearchDTO;
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
    public ResponseEntity<ResponseDTO> getGroupCodeList(
            @RequestParam(value = "groupCodeId", defaultValue = "0") int groupCodeId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        GroupCodeDTO groupCodeDTO = new GroupCodeDTO();

        groupCodeDTO.setGroupCodeId(groupCodeId);
        groupCodeDTO.setName(name);
        groupCodeDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                "getGroupCodeList Success",
                        groupCodeService.getGroupCodeList(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 리스트 조회 keyword")
    @GetMapping("/keyword")
    public ResponseEntity<ResponseDTO> getGroupCodeListKeyword(
            @RequestParam(value = "searchKey") String searchKey,
            @RequestParam(value = "keyword", defaultValue = "") String keyword
    ) {

        SearchDTO searchDTO = new SearchDTO();

        searchDTO.setSearchKey(searchKey);
        searchDTO.setKeyword(keyword);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.getGroupCodeListKeyword(searchDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 단건 조회")
    @GetMapping("/{groupCodeId}")
    public ResponseEntity<ResponseDTO> getGroupCode(@PathVariable("groupCodeId") int groupCodeId) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.getGroupCode(groupCodeId)
                )
        );
    }

    @Operation(summary = "그룹코드 등록")
    @PostMapping
    public ResponseEntity<ResponseDTO> insertGroupCode(@RequestBody GroupCodeDTO groupCodeDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.insertGroupCode(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 수정")
    @PutMapping
    public ResponseEntity<ResponseDTO> updateGroupCode(@RequestBody GroupCodeDTO groupCodeDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.updateGroupCode(groupCodeDTO)
                )
        );
    }

    @Operation(summary = "그룹코드 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteGroupCode(@RequestBody List<Integer> groupCodeId) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getGroupCodeList Success",
                        groupCodeService.deleteGroupCode(groupCodeId)
                )
        );
    }
}
