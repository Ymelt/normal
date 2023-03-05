package com.example.normal.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.normal.common.Result;
import com.example.normal.service.DoctorsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
