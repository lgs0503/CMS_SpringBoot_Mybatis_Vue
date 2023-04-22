package com.gs.bbs.menu;

import com.gs.bbs.api.menu.dto.MenuDTO;
import com.gs.bbs.api.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class MenuTest {

    private final MenuService menuService;

    @Autowired
    public MenuTest(MenuService menuService) {
        this.menuService = menuService;
    }

    @DisplayName("메뉴 리스트 조회")
    @Test
    public void getMenuList() {
        menuService.getMenuList();
    }

    @DisplayName("메뉴 조회")
    @Test
    public void getMenu() {
        menuService.getMenu(1);
    }

    @DisplayName("메뉴 추가")
    @Test
    public void insertMenu() {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setName("다음");
        menuDTO.setUpperMenuId(8);
        menuDTO.setUseYn("Y");
        menuDTO.setType("M003");
        menuDTO.setUrl("https://naver.com");
        menuDTO.setSort(1);
        menuDTO.setCreateUser("Junit_Test");

        menuService.insertMenu(menuDTO);

        getMenuList();
    }

    @DisplayName("메뉴 수정")
    @Test
    public void updateMenu() {

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuId(8);
        menuDTO.setName("링크");
        menuDTO.setUpperMenuId(1);
        menuDTO.setType("M003");
        menuDTO.setUrl("");
        menuDTO.setSort(1);
        menuDTO.setUpdateUser("Junit_Test");

        menuService.updateMenu(menuDTO);

        getMenuList();
    }

    @DisplayName("메뉴 삭제")
    @Test
    public void deleteMenu() {
        List<Integer> menuIds = new ArrayList<Integer>();

        menuIds.add(2);
        menuIds.add(4);
        menuIds.add(5);

        menuService.deleteMenu(menuIds);

        getMenuList();
    }
}
