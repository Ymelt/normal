package com.example.normal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = {"/testtest"})
public class TimeFilter implements Filter {
    Logger log = LoggerFactory.getLogger(Logger.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("【过滤器】初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("【过滤器】开始执行");
        Long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("【过滤器】耗时：" + (System.currentTimeMillis() - startTime)+"ms");
        log.info("【过滤器】结束执行");
    }

    @Override
    public void destroy() {
        log.info("【过滤器】销毁");
    }
}

