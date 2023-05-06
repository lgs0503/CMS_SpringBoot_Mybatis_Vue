package com.gs.bbs.api.groupCode.service;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.util.SearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupCodeService {

    List<GroupCodeDTO> getGroupCodeList(GroupCodeDTO groupCodeDTO);

    List<GroupCodeDTO> getGroupCodeListKeyword(SearchDTO searchDTO);

    GroupCodeDTO getGroupCode(int groupCodeId);

    int insertGroupCode(GroupCodeDTO groupCodeDTO);

    int updateGroupCode(GroupCodeDTO groupCodeDTO);

    int deleteGroupCode(@Param("groupCodeId") List<Integer> groupCodeId);
}
