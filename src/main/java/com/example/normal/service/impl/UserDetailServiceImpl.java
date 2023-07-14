package com.example.normal.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.normal.entity.LoginUser;
import com.example.normal.entity.SysUser;
import com.example.normal.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName,username);
        wrapper.last("limit 1");
        SysUser one = sysUserService.getOne(wrapper);

        if (Objects.isNull(one)){
            throw new RuntimeException("未找到此用户");
        }else {
            return createLoginUser(one);
        }


    }

    public LoginUser createLoginUser(SysUser user){
        LoginUser loginUser = new LoginUser();
        loginUser.setSysUser(user);
        loginUser.setUserId(user.getUserId());
        loginUser.setDeptId(user.getDeptId());
        return loginUser;
    }
}
