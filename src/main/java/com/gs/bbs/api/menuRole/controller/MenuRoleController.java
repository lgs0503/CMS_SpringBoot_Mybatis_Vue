package com.gs.bbs.api.menuRole.controller;

import com.gs.bbs.api.menuRole.dto.MenuRoleDTO;
import com.gs.bbs.api.menuRole.service.MenuRoleService;
import com.gs.bbs.util.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Menu Role", description = "메뉴 권한 api")
public class MenuRoleController {

    private final MenuRoleService menuRoleService;

    @Autowired
    public MenuRoleController(MenuRoleService menuRoleService) {
        this.menuRoleService = menuRoleService;
    }

    @Operation(summary = "메뉴 권한 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDto> getMenuRoleList(
            @RequestParam(value = "roleId", defaultValue = "0") int roleId,
            @RequestParam(value = "menuId", defaultValue = "0") int menuId,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ){

        MenuRoleDTO menuRoleDTO = new MenuRoleDTO();
        menuRoleDTO.setRoleId(roleId);
        menuRoleDTO.setMenuId(menuId);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getMenuRoleList Success",
                        menuRoleService.getMenuRoleList(menuRoleDTO)
                )
        );
    }

    @Operation(summary = "메뉴 권한 조회")
    @GetMapping("/{roleId}")
    public ResponseEntity<ResponseDto> getMenuRole(@PathVariable("roleId") int roleId){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getMenuRole Success",
                        menuRoleService.getMenuRole(roleId)
                )
        );
    }

    @Operation(summary = "메뉴 권한 추가")
    @PostMapping
    public ResponseEntity<ResponseDto> insertMenuRole(@RequestBody MenuRoleDTO menuRoleDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertMenuRole Success",
                        menuRoleService.insertMenuRole(menuRoleDTO)
                )
        );
    }

    @Operation(summary = "메뉴 권한 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updateMenuRole(@RequestBody MenuRoleDTO menuRoleDTO){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateMenuRole Success",
                        menuRoleService.updateMenuRole(menuRoleDTO)
                )
        );
    }

    @Operation(summary = "메뉴 권한 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteMenuRole(@RequestBody List<Integer> roleIds){
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteMenuRole Success",
                        menuRoleService.deleteMenuRole(roleIds)
                )
        );
    }
}
