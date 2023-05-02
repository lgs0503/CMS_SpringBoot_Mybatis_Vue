package com.gs.bbs.api.content.serivce;

import com.gs.bbs.api.content.dto.ContentDTO;

import java.util.List;

public interface ContentService {

    List<ContentDTO> getContentList(ContentDTO contentDTO);

    ContentDTO getContent(int contentId);

    int insertContent(ContentDTO contentDTO);

    int updateContent(ContentDTO contentDTO);

    int deleteContent(List<Integer> contentIds);

}
