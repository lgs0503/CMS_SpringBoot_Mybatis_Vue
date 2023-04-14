package com.gs.bbs.api.file.service;

import com.gs.bbs.api.file.dto.FileDownloadDTO;
import com.gs.bbs.util.ResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

public interface FileService {

    ResponseDto fileUpload(MultipartFile[] files);

    FileDownloadDTO downloadFile(int fileId) throws MalformedURLException;
}
