package com.gs.bbs.api.menuRole.service;

import com.gs.bbs.api.menuRole.dto.MenuRoleDTO;

import java.util.List;

public interface MenuRoleService {

    List<MenuRoleDTO> getMenuRoleList(MenuRoleDTO menuRoleDTO);

    MenuRoleDTO getMenuRole(int roleId);

    int insertMenuRole(MenuRoleDTO menuRoleDTO);

    int updateMenuRole(MenuRoleDTO menuRoleDTO);

    int deleteMenuRole(List<Integer> roleIds);

}
