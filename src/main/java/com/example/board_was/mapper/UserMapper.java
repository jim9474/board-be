package com.example.board_was.mapper;

import com.example.board_was.model.User;

public interface UserMapper {
    User getCheckId(String userId);

    void createUser(User user);

    String hashedPw(User userInfo);

    String getUserNn(String username);
}
