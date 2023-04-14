package com.gs.bbs.api.file.controller;

import com.gs.bbs.api.file.service.FileService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Slf4j
@RequestMapping("/file")
@Tag(name = "File", description = "파일 api")
public class FileController {

    @Autowired
    private FileService fileService;

    @Operation(summary = "파일 업로드")
    @PostMapping
    public ResponseEntity<ResponseDto> fileUpload(@RequestParam("files") MultipartFile[] files) {

        return ResponseEntity.ok(fileService.fileUpload(files));
    }
}
