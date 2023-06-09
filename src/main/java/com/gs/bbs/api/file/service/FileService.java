package com.gs.bbs.api.file.service;

import com.gs.bbs.api.file.dto.FileDownloadDTO;
import com.gs.bbs.util.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

    ResponseDTO uploadFile(MultipartFile[] files);

    FileDownloadDTO downloadFile(int fileId);

    String imageEncoder(int fileId);
}
