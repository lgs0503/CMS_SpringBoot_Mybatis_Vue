package com.gs.bbs.api.user.service;

import com.gs.bbs.api.user.dto.LoginDTO;
import com.gs.bbs.api.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUserList(UserDTO userDTO);

    UserDTO getUser(int userNo);

    String login(LoginDTO loginDTO);

    boolean userIdCheck(String userId);

    int insertUser(UserDTO userDTO);

    int updateUser(UserDTO userDTO);

    int updatePassword(LoginDTO loginDTO);

    int deleteUser(List<Integer> userNos);
}
