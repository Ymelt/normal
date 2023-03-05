package com.example.normal.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.normal.entity.SysUser;
import java.util.List;
import com.example.normal.mapper.SysUserMapper;
import com.example.normal.service.SysUserService;
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Override
    public int updateBatch(List<SysUser> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<SysUser> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<SysUser> list) {
        return baseMapper.batchInsert(list);
    }
}
