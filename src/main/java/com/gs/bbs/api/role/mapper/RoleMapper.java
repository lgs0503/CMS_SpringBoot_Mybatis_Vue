package com.gs.bbs.api.role.mapper;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.util.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<RoleDTO> getRoleList(RoleDTO roleDTO);

    List<RoleDTO> getRoleListKeyword(SearchDTO searchDTO);

    RoleDTO getRole(int roleId);

    int insertRole(RoleDTO roleDTO);

    int updateRole(RoleDTO roleDTO);

    int deleteRole(List<Integer> roleIds);
}
