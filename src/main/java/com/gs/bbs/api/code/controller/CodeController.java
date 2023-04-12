package com.gs.bbs.api.code.controller;

import com.gs.bbs.api.code.dto.CodeDTO;
import com.gs.bbs.api.code.service.CodeService;
import com.gs.bbs.util.ResponseDto;
import com.gs.bbs.util.StringUtil;
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

    @Autowired
    private CodeService codeService;

    @GetMapping
    public ResponseEntity<ResponseDto> getCodeList(@RequestParam("codeId") String codeId,
                                                   @RequestParam("groupCodeId") String groupCodeId,
                                                   @RequestParam("useYn") String useYn) {

        CodeDTO codeDTO = new CodeDTO();

        if (StringUtil.isNotEmpty(codeId))
            codeDTO.setCodeId(Integer.parseInt(codeId));

        if (StringUtil.isNotEmpty(groupCodeId))
            codeDTO.setGroupCodeId(Integer.parseInt(groupCodeId));

        codeDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getCodeList Success",
                        codeService.getCodeList(codeDTO)
                )
        );
    }

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
