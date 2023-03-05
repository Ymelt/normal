package com.example.normal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.normal.entity.Doctors;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DoctorsMapper extends BaseMapper<Doctors> {
    int batchInsert(@Param("list") List<Doctors> list);
}