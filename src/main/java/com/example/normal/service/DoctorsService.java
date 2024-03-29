package com.example.normal.service;

import java.util.List;

import com.example.normal.common.Result;
import com.example.normal.entity.Doctors;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

public interface DoctorsService extends IService<Doctors>{


    int batchInsert(List<Doctors> list);

    @Async("taskExecutor")
    void machThread();

    Result getInToTomorrow();

    Result insertGoing();

    void forTheRedisTest(Boolean b);

    void forTheRedisTestSecond();

    void sendMessage();

    String articleDetail();

    void beforeMethodGoOn();

}
