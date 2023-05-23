package com.gs.bbs.api.role.service;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.api.role.mapper.RoleMapper;
import com.gs.bbs.util.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> getRoleList(RoleDTO roleDTO) {
        return roleMapper.getRoleList(roleDTO);
    }

    @Override
    public List<RoleDTO> getRoleListKeyword(SearchDTO searchDTO) {
        return roleMapper.getRoleListKeyword(searchDTO);
    }

    @Override
    public RoleDTO getRole(int roleId) {
        return roleMapper.getRole(roleId);
    }

    @Override
    public int insertRole(RoleDTO roleDTO) {
        return roleMapper.insertRole(roleDTO);
    }

    @Override
    public int updateRole(RoleDTO roleDTO) {
        return roleMapper.updateRole(roleDTO);
    }

    @Override
    public int deleteRole(List<Integer> roleIds) {
        return roleMapper.deleteRole(roleIds);
    }
}
