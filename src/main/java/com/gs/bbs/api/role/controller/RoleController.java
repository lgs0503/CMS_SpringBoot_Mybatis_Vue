package com.gs.bbs.api.role.controller;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.api.role.service.RoleService;
import com.gs.bbs.util.ResponseDTO;
import com.gs.bbs.util.SearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Tag(name = "Role", description = "권한 api")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(summary = "권한 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDTO> getRoleList(
            @RequestParam(value = "roleId", defaultValue = "0") int roleId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleId);
        roleDTO.setName(name);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getRole Success",
                        roleService.getRoleList(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 리스트 조회 keyword")
    @GetMapping("/keyword")
    public ResponseEntity<ResponseDTO> getRoleListKeyword(
            @RequestParam(value = "searchKey", defaultValue = "") String searchKey,
            @RequestParam(value = "keyword", defaultValue = "") String keyword
    ) {

        SearchDTO searchDTO = new SearchDTO();

        searchDTO.setSearchKey(searchKey);
        searchDTO.setKeyword(keyword);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getRole Success",
                        roleService.getRoleListKeyword(searchDTO)
                )
        );
    }

    @Operation(summary = "권한 조회")
    @GetMapping("/{roleId}")
    public ResponseEntity<ResponseDTO> getRole(@PathVariable("roleId") int roleId) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getRole Success",
                        roleService.getRole(roleId)
                )
        );
    }

    @Operation(summary = "권한 추가")
    @PostMapping
    public ResponseEntity<ResponseDTO> insertRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertRole Success",
                        roleService.insertRole(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 수정")
    @PutMapping
    public ResponseEntity<ResponseDTO> updateRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updateRole Success",
                        roleService.updateRole(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteRole(@RequestBody List<Integer> roleIds) {
        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deleteRole Success",
                        roleService.deleteRole(roleIds)
                )
        );
    }
}
