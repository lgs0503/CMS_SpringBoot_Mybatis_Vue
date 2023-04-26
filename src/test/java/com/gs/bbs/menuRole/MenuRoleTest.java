package com.gs.bbs.menuRole;

import com.gs.bbs.api.menuRole.dto.MenuRoleDTO;
import com.gs.bbs.api.menuRole.service.MenuRoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class MenuRoleTest {

    private final MenuRoleService menuRoleService;

    @Autowired
    public MenuRoleTest(MenuRoleService menuRoleService) {
        this.menuRoleService = menuRoleService;
    }

    @Test
    @DisplayName("메뉴 별 권한 리스트 조회")
    public void getMenuRoleList() {
        MenuRoleDTO menuRoleDTO = new MenuRoleDTO();
        menuRoleDTO.setUseYn("Y");

        menuRoleService.getMenuRoleList(menuRoleDTO);
    }

    @Test
    @DisplayName("메뉴 별 권한 조회")
    public void getMenuRole() {
        menuRoleService.getMenuRole(1);
    }

    @Test
    @DisplayName("메뉴 별 권한 추가")
    public void insertMenuRole() {
        MenuRoleDTO menuRoleDTO = new MenuRoleDTO();

        menuRoleDTO.setMenuId(10);
        menuRoleDTO.setSelectYn("Y");
        menuRoleDTO.setInsertYn("Y");
        menuRoleDTO.setUpdateYn("Y");
        menuRoleDTO.setDeleteYn("Y");
        menuRoleDTO.setUploadYn("Y");
        menuRoleDTO.setDownloadYn("Y");
        menuRoleDTO.setUseYn("Y");

        menuRoleService.insertMenuRole(menuRoleDTO);

        getMenuRoleList();
    }

    @Test
    @DisplayName("메뉴 별 권한 수정")
    public void updateMenuRole() {
        MenuRoleDTO menuRoleDTO = new MenuRoleDTO();

        menuRoleDTO.setRoleId(2);
        menuRoleDTO.setMenuId(10);
        menuRoleDTO.setSelectYn("Y");
        menuRoleDTO.setInsertYn("N");
        menuRoleDTO.setUpdateYn("N");
        menuRoleDTO.setDeleteYn("N");
        menuRoleDTO.setUploadYn("N");
        menuRoleDTO.setDownloadYn("N");
        menuRoleDTO.setUseYn("Y");

        menuRoleService.updateMenuRole(menuRoleDTO);

        getMenuRoleList();
    }

    @Test
    @DisplayName("메뉴 별 권한 삭제")
    public void deleteMenuRole() {
        List<Integer> roleIds = new ArrayList<Integer>();

        roleIds.add(2);

        menuRoleService.deleteMenuRole(roleIds);

        getMenuRoleList();
    }
}
