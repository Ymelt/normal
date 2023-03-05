package com.example.normal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.normal.common.Result;
import com.example.normal.entity.Doctors;
import com.example.normal.mapper.DoctorsMapper;
import com.example.normal.service.DoctorsService;
import com.example.normal.util.JsonUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class DoctorsServiceImpl extends ServiceImpl<DoctorsMapper, Doctors> implements DoctorsService{



    @Override
    public int batchInsert(List<Doctors> list) {
        return baseMapper.batchInsert(list);
    }

    @Async("taskExecutor")
    @Override
    public void machThread() {
        LambdaQueryWrapper<Doctors> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Doctors::getId,1);
        Doctors doctors = baseMapper.selectById(1);
        doctors.setAge(doctors.getAge() + 1);
        baseMapper.update(doctors,wrapper);
//        try {
//            Thread.sleep(5000);
//            System.out.println("done");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }




    }

    @Override
    public Result getInToTomorrow() {
        List<Doctors> list = this.list(null);
        machThread();
        return JsonUtils.success(list);
    }

    @Override
    public Result insertGoing() {
        List<Doctors> list = new ArrayList<>();
        for (int i = 0; i < 10000;i++){
            Doctors doctors = new Doctors();
            doctors.setName("heh");
            doctors.setAge(i);
            list.add(doctors);
        }
//        this.saveBatch(list);
        baseMapper.batchInsert(list);
        return JsonUtils.success(null);
    }




}
