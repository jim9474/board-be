package com.example.board_was.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationConverter implements AuthenticationConverter {

    private final JwtUtil jwtUtil;

    @Override
    public Authentication convert(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            String userNn = jwtUtil.validateAndExtractUserNn(token);
            if(userNn != null) {
                return new JwtAuthenticationToken(userNn, null);
            }
        }
        return null;
    }
}
