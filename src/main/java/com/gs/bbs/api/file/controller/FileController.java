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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


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
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileId") int fileId, HttpServletRequest request) throws IOException {

        FileDownloadDTO fileDownloadDTO = fileService.downloadFile(fileId);

        HttpHeaders headers = new HttpHeaders();

        if (!getBrowser(request).contains("Firefox")) {
                    fileDownloadDTO.getFileDTO().setName(
                            URLEncoder.encode(
                                    fileDownloadDTO.getFileDTO().getName(),
                                        StandardCharsets.UTF_8
                                    )
                            .replaceAll("\\+", "%20")
                            .replaceAll("%2B", "+")
                            .replaceAll("%28", "(")
                            .replaceAll("%29", ")")
                            .replaceAll("%40", "@")
                    );
        } else {
            fileDownloadDTO.getFileDTO().setName(
                    new String(
                            fileDownloadDTO
                                    .getFileDTO()
                                    .getName()
                                    .getBytes(StandardCharsets.UTF_8)
                            , "8859_1"
                    )
            );
        }

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

    // 브라우저 별로 체크
    private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");

        if (header.contains("MSIE")) {
            return "MSIE";
        } else if (header.contains("Chrome")) {
            return "Chrome";
        } else if (header.contains("Opera")) {
            return "Opera";
        } else if (header.contains("Trident/7.0")){
            return "MSIE";
        } else{
            return "Firefox";
        }
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
