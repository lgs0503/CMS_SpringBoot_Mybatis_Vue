package com.gs.bbs.api.file.controller;

import com.gs.bbs.api.file.dto.FileDownloadDTO;
import com.gs.bbs.api.file.service.FileService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@Slf4j
@RequestMapping("/file")
@Tag(name = "File", description = "파일 api")
public class FileController {

    @Autowired
    private FileService fileService;

    @Operation(summary = "파일 업로드")
    @PostMapping
    public ResponseEntity<ResponseDto> uploadFile(@RequestParam("files") MultipartFile[] files) {

        return ResponseEntity.ok(fileService.uploadFile(files));
    }

    @Operation(summary = "파일 다운로드")
    @GetMapping
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileId") int fileId) throws IOException {

        FileDownloadDTO fileDownloadDTO = fileService.downloadFile(fileId);

        HttpHeaders headers = new HttpHeaders();

        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileDownloadDTO.getFileDTO().getName() + "\""
        );

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileDownloadDTO.getResource().contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileDownloadDTO.getResource());
    }

    @Operation(summary = "이미지 파일 인코딩 (섬네일)")
    @GetMapping("/imageEncoder")
    public ResponseEntity<ResponseDto> imageEncoder(@RequestParam("fileId") int fileId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "imageEncoder Success",
                        fileService.imageEncoder(fileId)
                )
        );
    }
}
