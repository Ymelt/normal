package com.example.normal.service.impl;

import cn.hutool.jwt.JWT;
import com.example.normal.constant.MyConstant;
import com.example.normal.service.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;


    @Override
    public String loginByUsernamePassword(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);

        //认证通过创建token
        String token = JWT.create()
                .setPayload("userName", username)
                .setKey(MyConstant.JWT_AUTHENTICATION_TYPE.getBytes(StandardCharsets.UTF_8))
                .sign();

        return token;
    }
}
