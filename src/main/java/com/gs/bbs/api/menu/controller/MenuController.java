package com.gs.bbs.api.menu.controller;

import com.gs.bbs.api.menu.dto.MenuDTO;
import com.gs.bbs.api.menu.service.MenuService;
import com.gs.bbs.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Slf4j
@Tag(name = "Menu", description = "메뉴 api")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @Operation(summary = "메뉴 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDTO> getMenuList(){

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getMenuList Success",
                        menuService.getMenuList()
                )
        );
    }

    @Operation(summary = "메뉴 조회")
    @GetMapping("/{menuId}")
    public ResponseEntity<ResponseDTO> getMenu(@PathVariable("menuId") int menuId){

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getMenu Success",
                        menuService.getMenu(menuId)
                )
        );
    }

    @Operation(summary = "메뉴 추가")
    @PostMapping
    public ResponseEntity<ResponseDTO> insertMenu(@RequestBody MenuDTO menuDTO){

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertMenu Success",
                        menuService.insertMenu(menuDTO)
                )
        );
    }

    @Operation(summary = "메뉴 수정")
    @PutMapping
    public ResponseEntity<ResponseDTO> updateMenu(@RequestBody MenuDTO menuDTO){

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "Success",
                        menuService.updateMenu(menuDTO)
                )
        );
    }

    @Operation(summary = "메뉴 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteMenu(@RequestBody List<Integer> menuIds){

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deleteMenu Success",
                        menuService.deleteMenu(menuIds)
                )
        );
    }
}
