package com.gs.bbs.api.user.service;

import com.gs.bbs.api.user.dto.LoginDTO;
import com.gs.bbs.api.user.dto.UserDTO;
import com.gs.bbs.api.user.mapper.UserMapper;
import com.gs.bbs.jwt.TokenProvider;
import com.gs.bbs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
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
    public String login(LoginDTO loginDTO) {

        String jwt = "";

        boolean loginResult = false;

        String savePassword = StringUtil.nvl(userMapper.getUserPassword(loginDTO.getUserId()));

        if (StringUtil.isNotEmpty(savePassword)) {
            String inputPassword = loginDTO.getPassword();

            loginResult =  passwordEncoder.matches(inputPassword, savePassword);
        }

        if (loginResult) {
            /* JWT 토큰 발급 */
            jwt = tokenProvider.createToken(loginDTO);
        }

        return jwt;
    }

    @Override
    public int insertUser(UserDTO userDTO) {

        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

        userDTO.setPassword(encryptedPassword);

        return userMapper.insertUser(userDTO);
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        return userMapper.updateUser(userDTO);
    }

    @Override
    public int updatePassword(LoginDTO loginDTO) {

        String encryptedPassword = passwordEncoder.encode(loginDTO.getPassword());

        loginDTO.setPassword(encryptedPassword);

        return userMapper.updatePassword(loginDTO);
    }

    @Override
    public int deleteUser(List<Integer> userNos) {
        return userMapper.deleteUser(userNos);
    }
}
