package com.example.normal.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.normal.common.Result;
import com.example.normal.service.DoctorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Resource
    private DoctorsService doctorsService;


    @RequestMapping("/getInToTomorrow")
    public Result getInToTomorrow(){
        return doctorsService.getInToTomorrow();
    }

    @RequestMapping("/insertGoing")
    public Result insertGoing(){
        return doctorsService.insertGoing();
    }

    @RequestMapping("/forTheRedisTest")
    public void forTheRedisTest(@RequestParam("bbb") Boolean b){
        doctorsService.forTheRedisTest(b);
    }

    @RequestMapping("/forTheRedisTestSecond")
    public void forTheRedisTestSecond(){
        doctorsService.forTheRedisTestSecond();
    }

    @RequestMapping("/doNotGoToGentle")
    public String doNotGoToGentle(){
        log.info("this is log testing");
        return "do not go gentle";

    }

}
