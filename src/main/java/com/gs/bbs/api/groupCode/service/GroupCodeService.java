package com.gs.bbs.api.groupCode.service;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;

import java.util.List;

public interface GroupCodeService {

    List<GroupCodeDTO> getGroupCodeList(GroupCodeDTO groupCodeDTO);

    GroupCodeDTO getGroupCode(int groupCodeId);

    int insertGroupCode(GroupCodeDTO groupCodeDTO);

    int updateGroupCode(GroupCodeDTO groupCodeDTO);

    int deleteGroupCode(List<Integer> groupCodeId);
}
