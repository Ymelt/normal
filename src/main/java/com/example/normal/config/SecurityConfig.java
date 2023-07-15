package com.example.normal.config;


import com.example.normal.security.JWTAuthenticationTokenFilter;
import com.example.normal.security.MyAccessDeniedHandler;
import com.example.normal.security.MyUnauthorizedHandler;
import com.example.normal.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

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
    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;
    @Resource
    private UserDetailsService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

//
//        System.out.println("123");
//        System.out.println("123");
//        System.out.println("123");
//        System.out.println("123");
//        //由于使用的是JWT，这里不需要csrf防护
//        httpSecurity.csrf().disable()
//                //基于token，所以不需要session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                //允许对于网站静态资源的无授权访问
//                .antMatchers(
//                        "/",
//                        "/*.html"
//                ).permitAll()
//                //对登录注册允许匿名访问
//                .antMatchers("/system/login", "/user/register").anonymous()
//                //跨域请求会先进行一次options请求
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                //测试时全部运行访问.permitAll();
//                .antMatchers("/test/**").permitAll().anyRequest().authenticated()
//                ;
//
//        //禁用缓存
//        httpSecurity.headers().cacheControl();
//        //将我们的JWT filter添加到UsernamePasswordAuthenticationFilter前面，因为这个Filter是authentication开始的filter，我们要早于它
//        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        httpSecurity.exceptionHandling().authenticationEntryPoint(myUnauthorizedHandler) .accessDeniedHandler(accessDeniedHandler);;
//        return httpSecurity.build();

        return httpSecurity
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 设置 jwtAuthError 处理认证失败、鉴权失败
                .exceptionHandling().authenticationEntryPoint(myUnauthorizedHandler).accessDeniedHandler(accessDeniedHandler).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        // 请求放开
                        .antMatchers("/organization/test/12").permitAll()
                        .antMatchers("/system/test/123").permitAll()
//                        .antMatchers("/**").permitAll()
                        // 其他地址的访问均需验证权限
                        .anyRequest().authenticated()
                )
                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                // 认证用户时用户信息加载配置，注入springAuthUserService
                .userDetailsService(userDetailService)
                .build();

    }

}
