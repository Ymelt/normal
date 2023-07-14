package com.example.normal.config;


import com.example.normal.filter.JWTAuthenticationTokenFilter;
import com.example.normal.filter.MyUnauthorizedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
       return new JWTAuthenticationTokenFilter();
    }

    @Resource
    public MyUnauthorizedHandler myUnauthorizedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //基于token，所以不需要csrf防护
        httpSecurity.csrf().disable()
                //基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //登录注册不需要认证
                .antMatchers("/**/login", "/user/register").permitAll()
                .antMatchers("/system/login").permitAll()
                //除上面的所有请求全部需要鉴权认证
                .anyRequest()
                .authenticated();
        //禁用缓存
        httpSecurity.headers().cacheControl();
        //将我们的JWT filter添加到UsernamePasswordAuthenticationFilter前面，因为这个Filter是authentication开始的filter，我们要早于它
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.exceptionHandling().authenticationEntryPoint(myUnauthorizedHandler);
        return httpSecurity.build();
    }
}
