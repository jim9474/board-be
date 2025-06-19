package com.example.board_was.util;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;


public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String token;
    private final Object principal;

    public JwtAuthenticationToken() {
        super(null);
        this.token = null;
        this.principal = null;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(String token) {
        super(null);
        this.token = token;
        this.principal = null;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = null;
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

}
