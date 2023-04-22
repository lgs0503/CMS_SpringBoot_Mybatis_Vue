package com.gs.bbs.api.menu.service;

import com.gs.bbs.api.menu.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    List<MenuDTO> getMenuList();

    MenuDTO getMenu(int menuId);

    int insertMenu(MenuDTO menuDTO);

    int updateMenu(MenuDTO menuDTO);

    int deleteMenu(List<Integer> menuIds);
}
