package com.gs.bbs.api.role.controller;

import com.gs.bbs.api.role.dto.RoleDTO;
import com.gs.bbs.api.role.service.RoleService;
import com.gs.bbs.util.ResponseDto;
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
    public ResponseEntity<ResponseDto> getRoleList(
            @RequestParam("roleId") int roleId,
            @RequestParam("name") String name,
            @RequestParam("useYn") String useYn
    ) {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleId);
        roleDTO.setName(name);

        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getRole Success",
                        roleService.getRoleList(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 조회")
    @GetMapping("/{roleId}")
    public ResponseEntity<ResponseDto> getRole(@PathVariable("roleId") int roleId) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "getRole Success",
                        roleService.getRole(roleId)
                )
        );
    }

    @Operation(summary = "권한 추가")
    @PostMapping
    public ResponseEntity<ResponseDto> insertRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "insertRole Success",
                        roleService.insertRole(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 수정")
    @PutMapping
    public ResponseEntity<ResponseDto> updateRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "updateRole Success",
                        roleService.updateRole(roleDTO)
                )
        );
    }

    @Operation(summary = "권한 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteRole(@RequestBody List<Integer> roleIds) {
        return ResponseEntity.ok(
                ResponseDto.of(
                        HttpStatus.OK,
                        "deleteRole Success",
                        roleService.deleteRole(roleIds)
                )
        );
    }
}
