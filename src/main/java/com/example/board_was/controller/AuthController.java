package com.example.board_was.controller;

import com.example.board_was.mapper.UserMapper;
import com.example.board_was.model.User;
import com.example.board_was.service.PasswordService;
import com.example.board_was.service.UserService;
import com.example.board_was.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordService passwordService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        User userInfo = new User();
        userInfo.setUserId(request.get("userId"));
        userInfo.setUserPw(request.get("userPw"));
        String hashedPw = userMapper.hashedPw(userInfo);
        System.out.println("hashedPw >> "+hashedPw);

        boolean match = passwordService.matches(request.get("userPw"), hashedPw);

        String token = jwtUtil.generateToken(request.get("userId"));
        if((hashedPw != null && hashedPw != "") && match) {
            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "user", Map.of("userId", request.get("userId"))
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "아이디 또는 비밀번호가 틀렸습니다."));
        }
    }

    @GetMapping("/auth/me")
    @ResponseBody
    public ResponseEntity<?> getAuth() {
        System.out.println("getAuth Controller Start...");
        // 현재 인증 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() != "anonymousUser") {
            return ResponseEntity.ok(auth);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

}
