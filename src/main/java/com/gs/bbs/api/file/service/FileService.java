package com.gs.bbs.api.file.service;

import com.gs.bbs.util.ResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    ResponseDto fileUpload(MultipartFile[] files);
}
