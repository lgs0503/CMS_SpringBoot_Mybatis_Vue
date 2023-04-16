package com.gs.bbs.api.role.service;

import com.gs.bbs.api.role.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getRoleList(RoleDTO roleDTO);

    RoleDTO getRole(int roleId);

    int insertRole(RoleDTO roleDTO);

    int updateRole(RoleDTO roleDTO);

    int deleteRole(List<Integer> roleIds);
}
