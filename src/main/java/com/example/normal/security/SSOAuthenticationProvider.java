package com.example.normal.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class SSOAuthenticationProvider implements AuthenticationProvider {



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SSOCodeAuthenticationToken codeAuthenticationToken = (SSOCodeAuthenticationToken) authentication;



        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
