package com.example.normal.controller;

import com.example.normal.common.Result;
import com.example.normal.dto.input.LoginInput;
import com.example.normal.service.LoginService;
import com.example.normal.util.JsonUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system")
public class LoginController {

    @Resource
    private LoginService loginService;


    @RequestMapping("/test/123")
    public Result login(@RequestBody LoginInput input){

        String token = loginService.loginByUsernamePassword(input.getUserName(), input.getPassword());


        return JsonUtils.success(token);


    }
}
