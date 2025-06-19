package com.example.board_was.service;

import com.example.board_was.mapper.UserMapper;
import com.example.board_was.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordService passwordService;

    @Override
    public void createUser(Map<String, Object> request) {
        User user = new User();
        String userPw = null;
        String hashedPw = null;
        try {
            userPw = (String) request.get("userPw");
            if(userPw != null || userPw != "") {
                hashedPw = passwordService.encodePassword(userPw);
            }

            user.setUserId((String) request.get("userId"));
            user.setUserPw(hashedPw);
            user.setUserEmail((String) request.get("userEmail"));
            user.setUserNn((String) request.get("userNn"));
            userMapper.createUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
