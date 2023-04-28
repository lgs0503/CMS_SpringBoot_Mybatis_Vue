package com.gs.bbs.api.popup.service;

import com.gs.bbs.api.popup.dto.PopupDTO;
import com.gs.bbs.api.popup.mapper.PopupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PopupServiceImpl implements PopupService{

    private final PopupMapper popupMapper;

    @Autowired
    public PopupServiceImpl(PopupMapper popupMapper) {
        this.popupMapper = popupMapper;
    }

    @Override
    public List<PopupDTO> getPopupList(PopupDTO popupDTO) {
        return popupMapper.getPopupList(popupDTO);
    }

    @Override
    public PopupDTO getPopup(int popupId) {
        return popupMapper.getPopup(popupId);
    }

    @Override
    public int insertPopup(PopupDTO popupDTO) {
        return popupMapper.insertPopup(popupDTO);
    }

    @Override
    public int updatePopup(PopupDTO popupDTO) {
        return popupMapper.updatePopup(popupDTO);
    }

    @Override
    public int deletePopup(List<Integer> popupIds) {
        return popupMapper.deletePopup(popupIds);
    }
}
