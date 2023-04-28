package com.gs.bbs.api.popup.service;

import com.gs.bbs.api.popup.dto.PopupDTO;

import java.util.List;

public interface PopupService {


    List<PopupDTO> getPopupList(PopupDTO popupDTO);

    PopupDTO getPopup(int popupId);

    int insertPopup(PopupDTO popupDTO);

    int updatePopup(PopupDTO popupDTO);

    int deletePopup(List<Integer> popupIds);

}
