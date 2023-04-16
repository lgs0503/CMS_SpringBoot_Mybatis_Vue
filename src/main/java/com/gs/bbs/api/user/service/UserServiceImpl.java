package com.gs.bbs.api.user.service;

import com.gs.bbs.api.user.dto.UserDTO;
import com.gs.bbs.api.user.mapper.UserMapper;
import com.gs.bbs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getUserList(UserDTO userDTO) {
        return userMapper.getUserList(userDTO);
    }

    @Override
    public UserDTO getUser(int userNo) {
        return userMapper.getUser(userNo);
    }

    @Override
    public boolean login(UserDTO userDTO) {

        boolean loginResult = false;

        String savePassword = StringUtil.nvl(userMapper.login(userDTO.getUserId()));

        if (StringUtil.isNotEmpty(savePassword)) {
            String inputPassword = userDTO.getPassword();

            loginResult =  passwordEncoder.matches(inputPassword, savePassword);
        }

        if (loginResult) {
            /* JWT 토큰 발급 */
        }

        return loginResult;
    }

    @Override
    public int insertUser(UserDTO userDTO) {

        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

        userDTO.setPassword(encryptedPassword);

        return userMapper.insertUser(userDTO);
    }

    @Override
    public int updateUser(UserDTO userDTO) {

        if (StringUtil.isNotEmpty(userDTO.getPassword())) {

            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

            userDTO.setPassword(encryptedPassword);
        }

        return userMapper.updateUser(userDTO);
    }

    @Override
    public int deleteUser(List<Integer> userNos) {
        return userMapper.deleteUser(userNos);
    }
}
