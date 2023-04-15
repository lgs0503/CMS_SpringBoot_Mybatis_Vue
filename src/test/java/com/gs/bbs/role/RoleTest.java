package com.gs.bbs.role;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.api.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class RoleTest {

    @Autowired
    RoleService roleService;

    @DisplayName("권한 리스트 조회")
    public void getRoleList() {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setUseYn("Y");

        List<RoleDTO> roleList = roleService.getRoleList(roleDTO);

        for (RoleDTO role : roleList) {
            log.debug(role.toString());
        }
    }

    @DisplayName("권한 조회")
    public void getRole() {
        RoleDTO roleDTO = roleService.getRole(1);
        log.debug(roleDTO.toString());
    }

    @DisplayName("권한 추가")
    public void insertRole(){

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("ADMIN");
        roleDTO.setCreateUser("admin");

        int result = roleService.insertRole(roleDTO);
        log.debug("insertGroupCode Result : " + result);

        getRoleList();
    }

    @DisplayName("권한 수정")
    public void updateRole(){

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(1);
        roleDTO.setName("ADMIN Test");
        roleDTO.setUpdateUser("admin");
        roleDTO.setUseYn("Y");

        int result = roleService.updateRole(null);
        log.debug("updateRole Result : " + result);

        getRoleList();
    }

    @DisplayName("권한 삭제")
    public void deleteRole(){

        List<Integer> roleIds = new ArrayList<Integer>();

        roleIds.add(1);

        int result = roleService.deleteRole(roleIds);
        log.debug("deleteRole Result : " + result);

        getRoleList();
    }

}
