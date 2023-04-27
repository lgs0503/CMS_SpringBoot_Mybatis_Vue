package com.gs.bbs.api.content.serivce;

import com.gs.bbs.api.content.dto.ContentDTO;
import com.gs.bbs.api.content.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    private final ContentMapper contentMapper;

    @Autowired
    public ContentServiceImpl(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Override
    public List<ContentDTO> getContentList(ContentDTO contentDTO) {
        return contentMapper.getContentList(contentDTO);
    }

    @Override
    public ContentDTO getContent(int contentId) {
        return contentMapper.getContent(contentId);
    }

    @Override
    public int insertContent(ContentDTO contentDTO) {
        return contentMapper.insertContent(contentDTO);
    }

    @Override
    public int updateContent(ContentDTO contentDTO) {
        return contentMapper.updateContent(contentDTO);
    }

    @Override
    public int deleteContent(List<Integer> contentIds) {
        return contentMapper.deleteContent(contentIds);
    }
}
