package com.gs.bbs.api.popup.mapper;

import com.gs.bbs.api.popup.dto.PopupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopupMapper {

    List<PopupDTO> getPopupList(PopupDTO popupDTO);

    PopupDTO getPopup(int popupId);

    int insertPopup(PopupDTO popupDTO);

    int updatePopup(PopupDTO popupDTO);

    int deletePopup(List<Integer> popupIds);

}

