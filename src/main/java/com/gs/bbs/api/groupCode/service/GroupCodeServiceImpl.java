package com.gs.bbs.api.groupCode.service;

import com.gs.bbs.api.groupCode.dto.GroupCodeDTO;
import com.gs.bbs.api.groupCode.mapper.GroupCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupCodeServiceImpl implements GroupCodeService {

    @Autowired
    GroupCodeMapper groupCodeMapper;

    @Override
    public List<GroupCodeDTO> getGroupCodeList(GroupCodeDTO groupCodeDTO) {
        return groupCodeMapper.getGroupCodeList(groupCodeDTO);
    }

    @Override
    public GroupCodeDTO getGroupCode(int groupCodeId) {
        return groupCodeMapper.getGroupCode(groupCodeId);
    }

    @Override
    public int insertGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeMapper.insertGroupCode(groupCodeDTO);
    }

    @Override
    public int updateGroupCode(GroupCodeDTO groupCodeDTO) {
        return groupCodeMapper.updateGroupCode(groupCodeDTO);
    }

    @Override
    public int deleteGroupCode(List<Integer> groupCodeId) {
        return groupCodeMapper.deleteGroupCode(groupCodeId);
    }
}
