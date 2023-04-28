package com.gs.bbs.api.file.service;

import com.gs.bbs.api.file.dto.FileDTO;
import com.gs.bbs.api.file.dto.FileDownloadDTO;
import com.gs.bbs.api.file.mapper.FileMapper;
import com.gs.bbs.util.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Slf4j
public class FileServiceImpl implements FileService{

    private final FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Transactional
    @Override
    public ResponseDTO uploadFile(MultipartFile[] files) {
        ResponseDTO responseDto;

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

                makeFolder(uploadDir);

                file.transferTo(dest);
            }

            responseDto = ResponseDTO.of(HttpStatus.OK, "fileUpload Success", result);
        } catch (IOException e) {
            log.error("fileUpload Exception: " + e.getMessage());
            responseDto = ResponseDTO.of(HttpStatus.NOT_FOUND, "fileUpload Fail");
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

    private void makeFolder(String path){

        File Folder = new File(path);

        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
        if (!Folder.exists()) {
            try {
                Folder.mkdirs(); //폴더 생성합니다.
                log.info("makeFolder Success");
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            log.error("A folder has already been created.");
        }

    }

    @Override
    public FileDownloadDTO downloadFile(int fileId) {

        FileDownloadDTO fileDownloadDTO = new FileDownloadDTO();

        try {

            FileDTO fileDTO = fileMapper.getFileDetail(fileId);

            Path path = Paths.get(fileDTO.getPath(), fileDTO.getUuidName());
            Resource resource = new UrlResource(path.toUri());

            fileDownloadDTO.setFileDTO(fileDTO);
            fileDownloadDTO.setResource(resource);

        } catch (MalformedURLException e) {
            log.error("downloadFile Exception: " + e.getMessage());
        }

        return fileDownloadDTO;
    }


    @Override
    public String imageEncoder(int fileId) {

        String encodedImage = "";

        try {
            FileDTO fileDTO = fileMapper.getFileDetail(fileId);

            String imagePath = fileDTO.getPath() + File.separator + fileDTO.getUuidName();

            File file = new File(imagePath);

            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];

            fis.read(data);
            fis.close();

            encodedImage = Base64.getEncoder().encodeToString(data);
        } catch (IOException e) {
            log.error("imageEncoder Exception: " + e.getMessage());
        }

        return encodedImage;
    }
}
