package com.gs.bbs.api.role.mapper;

import com.gs.bbs.api.role.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<RoleDTO> getRoleList(RoleDTO roleDTO);

    RoleDTO getRole(int roleId);

    int insertRole(RoleDTO roleDTO);

    int updateRole(RoleDTO roleDTO);

    int deleteRole(List<Integer> roleIds);
}
