package com.gs.bbs.api.menuRole.service;

import com.gs.bbs.api.menuRole.dto.MenuRoleDTO;
import com.gs.bbs.api.menuRole.mapper.MenuRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuRoleServiceImpl implements MenuRoleService {

    private final MenuRoleMapper menuRoleMapper;

    @Autowired
    public MenuRoleServiceImpl(MenuRoleMapper menuRoleMapper) {
        this.menuRoleMapper = menuRoleMapper;
    }

    @Override
    public List<MenuRoleDTO> getMenuRoleList(MenuRoleDTO menuRoleDTO) {
        return menuRoleMapper.getMenuRoleList(menuRoleDTO);
    }

    @Override
    public MenuRoleDTO getMenuRole(int roleId) {
        return menuRoleMapper.getMenuRole(roleId);
    }

    @Override
    public int insertMenuRole(MenuRoleDTO menuRoleDTO) {
        return menuRoleMapper.insertMenuRole(menuRoleDTO);
    }

    @Override
    public int updateMenuRole(MenuRoleDTO menuRoleDTO) {
        return menuRoleMapper.updateMenuRole(menuRoleDTO);
    }

    @Override
    public int deleteMenuRole(List<Integer> roleIds) {
        return menuRoleMapper.deleteMenuRole(roleIds);
    }
}
