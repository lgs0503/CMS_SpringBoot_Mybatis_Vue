package com.gs.bbs.api.menu.mapper;

import com.gs.bbs.api.menu.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> getMenuList();

    MenuDTO getMenu(int menuId);

    int insertMenu(MenuDTO menuDTO);

    int updateMenu(MenuDTO menuDTO);

    int deleteMenu(List<Integer> menuIds);

}
