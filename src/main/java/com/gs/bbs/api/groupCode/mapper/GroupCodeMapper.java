package com.gs.bbs.api.groupCode.mapper;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupCodeMapper {

    List<GroupCodeDTO> getGroupCodeList(GroupCodeDTO groupCodeDTO);

    GroupCodeDTO getGroupCode(int groupCodeId);

    int insertGroupCode(GroupCodeDTO groupCodeDTO);

    int updateGroupCode(GroupCodeDTO groupCodeDTO);

    int deleteGroupCode(List<Integer> groupCodeId);
}
