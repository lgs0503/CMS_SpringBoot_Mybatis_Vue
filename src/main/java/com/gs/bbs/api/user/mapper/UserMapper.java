package com.gs.bbs.api.user.mapper;

import com.gs.bbs.api.user.dto.LoginDTO;
import com.gs.bbs.api.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDTO> getUserList(UserDTO userDTO);

    UserDTO getUser(int userNo);

    String getUserPassword(String userId);

    int insertUser(UserDTO userDTO);

    int updateUser(UserDTO userDTO);

    int updatePassword(LoginDTO loginDTO);

    int deleteUser(List<Integer> userNos);
}
