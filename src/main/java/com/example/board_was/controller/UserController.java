package com.example.board_was.controller;

import com.example.board_was.mapper.UserMapper;
import com.example.board_was.model.User;
import com.example.board_was.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserService userService;

    @GetMapping("/getCheckId")
    @ResponseBody
    public User getCheckId(@RequestParam String userId) {
        System.out.println("userId >>> "+userId);
        return userMapper.getCheckId(userId);

    }

}
