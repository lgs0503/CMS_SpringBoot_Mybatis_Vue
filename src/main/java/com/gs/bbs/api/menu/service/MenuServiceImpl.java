package com.gs.bbs.api.menu.service;

import com.gs.bbs.api.menu.dto.MenuDTO;
import com.gs.bbs.api.menu.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<MenuDTO> getMenuList() {
        return menuMapper.getMenuList();
    }

    @Override
    public MenuDTO getMenu(int menuId) {
        return menuMapper.getMenu(menuId);
    }

    @Override
    public int insertMenu(MenuDTO menuDTO) {
        return menuMapper.insertMenu(menuDTO);
    }

    @Override
    public int updateMenu(MenuDTO menuDTO) {
        return menuMapper.updateMenu(menuDTO);
    }

    @Override
    public int deleteMenu(List<Integer> menuIds) {
        return menuMapper.deleteMenu(menuIds);
    }
}
