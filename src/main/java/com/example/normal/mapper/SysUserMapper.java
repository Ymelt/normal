package com.example.normal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.normal.entity.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    int updateBatch(List<SysUser> list);

    int updateBatchSelective(List<SysUser> list);

    int batchInsert(@Param("list") List<SysUser> list);
}