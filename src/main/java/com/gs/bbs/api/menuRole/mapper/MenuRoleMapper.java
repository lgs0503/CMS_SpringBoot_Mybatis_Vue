package com.gs.bbs.api.menuRole.mapper;

import com.gs.bbs.api.menuRole.dto.MenuRoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    List<MenuRoleDTO> getMenuRoleList(MenuRoleDTO menuRoleDTO);

    MenuRoleDTO getMenuRole(int roleId);

    int insertMenuRole(MenuRoleDTO menuRoleDTO);

    int updateMenuRole(MenuRoleDTO menuRoleDTO);

    int deleteMenuRole(List<Integer> roleIds);

}
