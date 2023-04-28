package com.gs.bbs.api.user.controller;

import com.gs.bbs.api.user.dto.LoginDTO;
import com.gs.bbs.api.user.dto.UserDTO;
import com.gs.bbs.api.user.service.UserService;
import com.gs.bbs.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "회원 api (로그인 회원가입등 유저와 관련된 것들)")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원 리스트 조회")
    @GetMapping
    public ResponseEntity<ResponseDTO> getUserList(
            @RequestParam(value = "userNo", defaultValue = "0") int userNo,
            @RequestParam(value = "userId", defaultValue = "") String userId,
            @RequestParam(value = "korName", defaultValue = "") String korName,
            @RequestParam(value = "roleId", defaultValue = "0") int roleId,
            @RequestParam(value = "useYn", defaultValue = "Y") String useYn
    ) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserNo(userNo);
        userDTO.setUserId(userId);
        userDTO.setKorName(korName);
        userDTO.setRoleId(roleId);
        userDTO.setUseYn(useYn);

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getUserList Success",
                        userService.getUserList(userDTO)
                )
        );
    }

    @Operation(summary = "회원 조회")
    @GetMapping("/{userNo}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("userNo") int userNo) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "getUser Success",
                        userService.getUser(userNo)
                )
        );
    }

    @Operation(summary = "회원 조회 ( 로그인 )")
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) {

        String token = userService.login(loginDTO);

        if (token.equals("")) {

            return ResponseEntity.ok(
                    ResponseDTO.of(
                            HttpStatus.NOT_FOUND,
                            "login Fail"
                    )
            );
        } else {
            return ResponseEntity.ok(
                    ResponseDTO.of(
                            HttpStatus.OK,
                            "login Success",
                            token
                    )
            );
        }
    }

    @Operation(summary = "아이디 중복체크 사용가능 true 사용불가 false")
    @GetMapping("/userIdCheck")
    public ResponseEntity<ResponseDTO> userIdCheck(
            @RequestParam(value = "userId", defaultValue = "") String userId
    ) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "login Success",
                        userService.userIdCheck(userId)
                )
        );
    }

    @Operation(summary = "회원 추가 ( 회원가입 )")
    @PostMapping
    public ResponseEntity<ResponseDTO> insertUser(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "insertUser Success",
                        userService.insertUser(userDTO)
                )
        );
    }

    @Operation(summary = "회원 수정")
    @PutMapping
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updateUser Success",
                        userService.updateUser(userDTO)
                )
        );
    }


    @Operation(summary = "비밀번호 변경")
    @PatchMapping
    public ResponseEntity<ResponseDTO> updatePassword(@RequestBody LoginDTO loginDTO) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "updatePassword Success",
                        userService.updatePassword(loginDTO)
                )
        );
    }

    @Operation(summary = "회원 삭제")
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteUser(@RequestBody List<Integer> userNos) {

        return ResponseEntity.ok(
                ResponseDTO.of(
                        HttpStatus.OK,
                        "deleteUser Success",
                        userService.deleteUser(userNos)
                )
        );
    }
}
