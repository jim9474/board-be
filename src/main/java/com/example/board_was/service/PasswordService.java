package com.example.board_was.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encodePassword(String userPw) {
        return passwordEncoder.encode(userPw);
    }

    public boolean matches(String userPw, String hashedPw) {
        return passwordEncoder.matches(userPw, hashedPw);
    }

}
