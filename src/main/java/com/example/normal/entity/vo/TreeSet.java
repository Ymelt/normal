package com.example.normal.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeSet {

    private Integer id;

    private String name;

    private Integer pid;

    private List<TreeSet> children = new ArrayList<>();
}
