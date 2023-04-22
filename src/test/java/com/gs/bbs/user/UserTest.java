package com.gs.bbs.user;

import com.gs.bbs.api.user.dto.LoginDTO;
import com.gs.bbs.api.user.dto.UserDTO;
import com.gs.bbs.api.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class UserTest {

    private final UserService userService;

    @Autowired
    public UserTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    @DisplayName("회원 리스트 조회")
    public void getUserList() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUseYn("Y");

         userService.getUserList(userDTO);
    }

    @Test
    @DisplayName("회원 조회")
    public void getUser() {
        userService.getUser(1);
    }

    @Test
    @DisplayName("로그인")
    public void login() {

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUserId("testId");
        loginDTO.setPassword("12345");

        String token = userService.login(loginDTO);

        log.info("jwtToken : " + token);
    }

    @Test
    @DisplayName("아이디 중복체크")
    public void userIdCheck() {
        String userId = "testId1";

        boolean result = userService.userIdCheck(userId);

        log.info("userIdCheck Result : " + result);
    }

    @Test
    @DisplayName("회원 추가")
    public void insertUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("testId");
        userDTO.setPassword("1234");
        userDTO.setKorName("테스터");
        userDTO.setEngName("tester");
        userDTO.setRoleId(1);
        userDTO.setUseYn("Y");
        userDTO.setAddress("테스터 주소");
        userDTO.setAddressDtl("테스터 주소 상세");
        userDTO.setEmail("test@naver.com");
        userDTO.setGender("G002");
        userDTO.setCreateUser("Junit_Test");

        userService.insertUser(userDTO);

        getUserList();
    }

    @Test
    @DisplayName("회원 수정")
    public void updateUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserNo(2);
        userDTO.setUserId("testId");
        userDTO.setKorName("테스터수정");
        userDTO.setEngName("testerUpdate");
        userDTO.setRoleId(1);
        userDTO.setUseYn("Y");
        userDTO.setAddress("테스터 주소");
        userDTO.setAddressDtl("테스터 주소 상세");
        userDTO.setEmail("test@naver.com");
        userDTO.setGender("G001");
        userDTO.setUpdateUser("Junit_Test");

        userService.updateUser(userDTO);

        getUserList();
    }

    @Test
    @DisplayName("비밀번호 수정")
    public void updatePassword() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserId("testId");
        loginDTO.setPassword("12345");

        userService.updatePassword(loginDTO);
    }

    @Test
    @DisplayName("회원 삭제")
    public void deleteUser() {

        List<Integer> userNos = new ArrayList<Integer>();
        userNos.add(2);

        userService.deleteUser(userNos);

        getUserList();
    }
}
