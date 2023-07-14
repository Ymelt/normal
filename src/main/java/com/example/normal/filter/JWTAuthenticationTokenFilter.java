package com.example.normal.filter;

import cn.hutool.jwt.JWTUtil;
import com.example.normal.constant.MyConstant;
import com.example.normal.entity.LoginUser;
import com.example.normal.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Slf4j
public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //先校验token
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)){
            filterChain.doFilter(request,response);
            return;
        }

        boolean verify = JWTUtil.verify(authorization, MyConstant.JWT_AUTHENTICATION_TYPE.getBytes(StandardCharsets.UTF_8));
        if (!verify){
            filterChain.doFilter(request,response);
            return;
        }

        String userName = (String)JWTUtil.parseToken(authorization).getPayload("userName");
        LoginUser loginUser = (LoginUser)userDetailsService.loadUserByUsername(userName);
        SysUser sysUser = loginUser.getSysUser();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUserName(), sysUser.getPassword(), loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request,response);

    }
}
