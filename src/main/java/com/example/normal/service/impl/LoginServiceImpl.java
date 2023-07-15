package com.example.normal.service.impl;

import cn.hutool.jwt.JWT;
import com.example.normal.constant.MyConstant;
import com.example.normal.security.SSOCodeAuthenticationToken;
import com.example.normal.service.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;


    @Override
    public String loginByUsernamePassword(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
//        System.out.println("123");
//        System.out.println("123");
        authenticationManager.authenticate(authenticationToken);

        //认证通过创建tokeno
        String token = JWT.create()
                .setPayload("userName", username)
                .setKey(MyConstant.JWT_AUTHENTICATION_TYPE.getBytes(StandardCharsets.UTF_8))
                .sign();
        return token;
    }
}
