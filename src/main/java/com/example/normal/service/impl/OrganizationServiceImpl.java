package com.example.normal.service.impl;

import com.example.normal.entity.vo.TreeSet;
import com.example.normal.pojo.Organization;
import com.example.normal.mapper.OrganizationMapper;
import com.example.normal.service.OrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Johnny
 * @since 2023-03-05
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Override
    public List<TreeSet> buildTree() {
        List<Organization> list = this.list(null);
        List<TreeSet> treeSetList = list.stream().map(s -> {
            TreeSet treeSet = new TreeSet();
            BeanUtils.copyProperties(s, treeSet);
            return treeSet;
        }).collect(Collectors.toList());
        List<Integer> pidList = list.stream().map(Organization::getPid).collect(Collectors.toList());
        List<TreeSet> collect = treeSetList.stream().filter(s -> Objects.equals(0, s.getPid())).collect(Collectors.toList());
        for (TreeSet treeSet : collect) {
            if (Objects.equals(treeSet.getPid(),0)){
                findChildren(treeSetList,treeSet);
            }
        }
        return collect;
    }

    public void findChildren(List<TreeSet> list,TreeSet treeSet){
        for (TreeSet set : list) {
            if (Objects.equals(set.getPid(),treeSet.getId())){
                findChildren(list,set);
                treeSet.getChildren().add(set);
            }
        }
    }
}
