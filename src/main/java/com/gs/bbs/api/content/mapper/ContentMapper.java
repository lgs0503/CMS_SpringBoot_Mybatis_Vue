package com.gs.bbs.api.content.mapper;

import com.gs.bbs.api.content.dto.ContentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<ContentDTO> getContentList(ContentDTO contentDTO);

    ContentDTO getContent(int contentId);

    int insertContent(ContentDTO contentDTO);

    int updateContent(ContentDTO contentDTO);

    int deleteContent(List<Integer> contentIds);

}
