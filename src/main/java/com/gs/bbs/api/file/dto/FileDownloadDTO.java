package com.gs.bbs.api.file.dto;

import lombok.*;
import org.springframework.core.io.Resource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDownloadDTO{

    private FileDTO fileDTO;
    private Resource resource;
}
