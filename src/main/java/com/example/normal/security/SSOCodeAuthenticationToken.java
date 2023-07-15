package com.example.normal.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import javax.security.auth.Subject;

public class SSOCodeAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 570L;
    private final Object principal;

    public SSOCodeAuthenticationToken(Object principal) {
        super((Collection)null);
        this.principal = principal;
        this.setAuthenticated(false);
    }

    public SSOCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    public static SSOCodeAuthenticationToken unauthenticated(Object principal) {
        return new SSOCodeAuthenticationToken(principal);
    }

    public static SSOCodeAuthenticationToken authenticated(Object principal, Collection<? extends GrantedAuthority> authorities) {
        return new SSOCodeAuthenticationToken(principal, authorities);
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
