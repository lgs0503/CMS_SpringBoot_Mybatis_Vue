package com.gs.bbs.api.file.mapper;

import com.gs.bbs.api.file.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    int insertFileMaster(FileDTO fileDTO);

    int getMaxMasterFileId();

    int insertFileDetail(FileDTO fileDTO);

    FileDTO getFileDetail(FileDTO fileDTO);
}
