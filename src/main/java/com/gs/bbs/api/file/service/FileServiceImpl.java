package com.gs.bbs.api.file.service;

import com.gs.bbs.api.file.dto.FileDTO;
import com.gs.bbs.api.file.mapper.FileMapper;
import com.gs.bbs.util.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService{

    @Autowired
    private FileMapper fileMapper;

    @Transactional
    @Override
    public ResponseDto fileUpload(MultipartFile[] files) {
        ResponseDto responseDto;

        List<FileDTO> result = new ArrayList<FileDTO>();

        FileDTO fileDTO = new FileDTO();
        fileDTO.setCreateUser("Admin");

        int insertFileMasterResult = fileMapper.insertFileMaster(fileDTO);

        log.info("insertFileMasterResult :" + insertFileMasterResult);

        int masterFileId = fileMapper.getMaxMasterFileId();

        fileDTO.setMasterFileId(masterFileId);

        try {

            int sort = 1;

            for (MultipartFile file : files) {

                String fileName = file.getOriginalFilename();
                UUID uuid = UUID.randomUUID();
                String extension = getExtension(Objects.requireNonNull(fileName));
                long fileSize = file.getSize();
                String uploadDir = "c://uploads";
                String filePath = uploadDir + File.separator + uuid;
                File dest = new File(filePath);

                fileDTO.setName(fileName);
                fileDTO.setUuidName(uuid.toString());
                fileDTO.setSort(sort++);
                fileDTO.setSize((int) fileSize);
                fileDTO.setPath(uploadDir);
                fileDTO.setExten(extension);

                result.add(fileDTO);

                int insertFileDetailResult = fileMapper.insertFileDetail(fileDTO);
                log.info("insertFileDetailResult :" + insertFileDetailResult);

                file.transferTo(dest);
            }

            responseDto = ResponseDto.of(HttpStatus.OK, "fileUpload Success", result);
        } catch (IOException e) {
            log.error(e.getMessage());
            responseDto = ResponseDto.of(HttpStatus.NOT_FOUND, "fileUpload Fail");
        }

        return responseDto;
    }

    private String getExtension(String fileName){
        int index = fileName.lastIndexOf(".");
        String extension = "";
        if (index > 0) {
            extension = fileName.substring(index + 1);

            log.info("getExtension Result : " + extension);
        }
        return extension;
    }

    @GetMapping
    public ResponseEntity<Resource> downloadFile(@RequestParam int fileId) throws IOException {

        FileDTO fileDTO = fileMapper.getFileDetail(fileId);

        Path path = Paths.get(fileDTO.getPath(), fileDTO.getUuidName());
        Resource resource = new UrlResource(path.toUri());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDTO.getName() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
