package com.gs.bbs.api.code.controller;

import com.gs.bbs.api.code.dto.CodeDTO;
import com.gs.bbs.api.code.service.CodeService;
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
@Tag(name = "Code", description = "코드 api")
@RestController
@RequestMapping("/code")
public class CodeController {

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @Operation(summary = "코드 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getCodeList(
            @RequestParam(value = "codeId", defaultValue = "0") String codeId,
            @RequestParam(value = "groupCodeId", defaultValue = "0") String groupCodeId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        CodeDTO codeDTO = new CodeDTO();

        if (StringUtil.isNotEmpty(codeId))
            codeDTO.setCodeId(Integer.parseInt(codeId));

        if (StringUtil.isNotEmpty(groupCodeId))
            codeDTO.setGroupCodeId(Integer.parseInt(groupCodeId));

        codeDTO.setName(name);
        codeDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getCodeList Success",
                        codeService.getCodeList(codeDTO)
                )
        );
    }

    @Operation(summary = "코드 조회")
    @GetMapping("/{code}")
    public ResponseEntity<ResponseDto> getCode(@PathVariable("code") int codeId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getCode Success",
                        codeService.getCode(codeId)
                )
        );
    }

    @Operation(summary = "코드 추가")
    @PostMapping
    public ResponseEntity<ResponseDto> insertCode(@RequestBody CodeDTO codeDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertCode Success",
                        codeService.insertCode(codeDTO)
                )
        );
    }

    @Operation(summary = "코드 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updateCode(@RequestBody CodeDTO codeDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateCode Success",
                        codeService.updateCode(codeDTO)
                )
        );
    }

    @Operation(summary = "코드 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteCode(@RequestBody List<Integer> codeIds) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteCode Success",
                        codeService.deleteCode(codeIds)
                )
        );
    }
}
