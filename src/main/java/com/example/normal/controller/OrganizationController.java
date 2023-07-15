package com.example.normal.controller;


import com.example.normal.common.Result;
import com.example.normal.service.OrganizationService;
import com.example.normal.util.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Johnny
 * @since 2023-03-05
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;

    @RequestMapping("/getTree")
    public Result getTree(){
        return JsonUtils.success(organizationService.buildTree());
    }

    @RequestMapping("/test/12")
    public Result test12(){
        return JsonUtils.success("this is sunday ' class");
    }
}

