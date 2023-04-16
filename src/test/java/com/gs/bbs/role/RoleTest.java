package com.gs.bbs.role;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.api.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class RoleTest {

    @Autowired
    RoleService roleService;

    @Test
    @DisplayName("권한 리스트 조회")
    public void getRoleList() {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setUseYn("Y");

        List<RoleDTO> roleList = roleService.getRoleList(roleDTO);

        for (RoleDTO role : roleList) {
            log.debug(role.toString());
        }
    }

    @Test
    @DisplayName("권한 조회")
    public void getRole() {
        RoleDTO roleDTO = roleService.getRole(1);
        log.debug(roleDTO.toString());
    }

    @Test
    @DisplayName("권한 추가")
    public void insertRole(){

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("TESTER");
        roleDTO.setCreateUser("admin");

        int result = roleService.insertRole(roleDTO);
        log.debug("insertGroupCode Result : " + result);

        getRoleList();
    }

    @Test
    @DisplayName("권한 수정")
    public void updateRole(){

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(3);
        roleDTO.setName("TESTER_UPDATE");
        roleDTO.setUpdateUser("admin");

        int result = roleService.updateRole(roleDTO);
        log.debug("updateRole Result : " + result);

        getRoleList();
    }

    @Test
    @DisplayName("권한 삭제")
    public void deleteRole(){

        List<Integer> roleIds = new ArrayList<Integer>();

        roleIds.add(3);

        int result = roleService.deleteRole(roleIds);
        log.debug("deleteRole Result : " + result);

        getRoleList();
    }
}
