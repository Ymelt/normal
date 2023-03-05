package com.example.normal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "doctors")
public class Doctors implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    private static final long serialVersionUID = 1L;

    public static final String COL_NAME = "name";

    public static final String COL_AGE = "age";
}