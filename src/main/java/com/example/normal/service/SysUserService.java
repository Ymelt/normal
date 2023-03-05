package com.example.normal.service;

import com.example.normal.entity.SysUser;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
public interface SysUserService extends IService<SysUser>{


    int updateBatch(List<SysUser> list);

    int updateBatchSelective(List<SysUser> list);

    int batchInsert(List<SysUser> list);

}
