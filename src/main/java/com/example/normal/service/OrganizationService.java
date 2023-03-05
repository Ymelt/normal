package com.example.normal.service;

import com.example.normal.entity.vo.TreeSet;
import com.example.normal.pojo.Organization;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Johnny
 * @since 2023-03-05
 */
public interface OrganizationService extends IService<Organization> {


    List<TreeSet> buildTree();

}
