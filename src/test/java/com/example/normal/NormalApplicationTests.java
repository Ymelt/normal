package com.example.normal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.normal.mapper.master.SysUserMapper;
import com.example.normal.mapper.slave.SlaveSysUserMapper;
import com.example.normal.pojo.master.SysUser;
import com.example.normal.pojo.slave.SlaveSysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NormalApplicationTests {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SlaveSysUserMapper slaveSysUserMapper;


    @Test
    public void test1(){
        List<SysUser> masterUserList = sysUserMapper.selectList(null);
        System.out.println("masterUserList: " + masterUserList);
        Integer slaveTotal = slaveSysUserMapper.selectCount(null);
        System.out.println("slaveTotal: " + slaveTotal);

//        LambdaQueryWrapper<SlaveSysUser> slaveWrapper = new LambdaQueryWrapper<>();
//        slaveWrapper.eq(SlaveSysUser::getUserId, 3);
        SlaveSysUser slaveSysUser = slaveSysUserMapper.selectById(3);
        SysUser insertOne = new SysUser();
        BeanUtils.copyProperties(slaveSysUser,insertOne);

        int insertTotal = sysUserMapper.insert(insertOne);
        System.out.println("成功插入了" + insertTotal + "条数据");


    }
}
