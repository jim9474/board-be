package com.example.board_was.controller;

import com.example.board_was.mapper.UserMapper;
import com.example.board_was.model.Board;
import com.example.board_was.model.User;
import com.example.board_was.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    private final UserService userService;

    @GetMapping("/getCheckId")
    @ResponseBody
    public User getCheckId(@RequestParam String userId) {
        System.out.println("userId >>> "+userId);
        return userMapper.getCheckId(userId);
    }

    @PostMapping("/createUser")
    @ResponseBody
    public void createUser(@RequestBody Map<String, Object> request) {
        System.out.println("createUser Controller Start..");
        userService.createUser(request);
    }

}
