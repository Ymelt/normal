package com.example.normal.security;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errCode","2001");
        jsonObject.put("data",null);
        jsonObject.put("msg","not authentication");
        response.getWriter().println(jsonObject.toJSONString());
        response.getWriter().flush();
    }
}