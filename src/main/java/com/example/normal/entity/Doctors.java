package com.example.normal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.normal.annotaion.FieldImport;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "doctors")
public class Doctors implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    @FieldImport(orderValue = 1,clownNameInCh = "姓名",clownName = "name")
    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    @FieldImport(orderValue = 3,clownNameInCh = "年龄",clownName = "age")
    private Integer age;

    @TableField(value = "degree")
    @FieldImport(orderValue = 4,clownNameInCh = "教育背景",clownName = "degree")
    private String degree;

    @TableField(exist = false)
    @FieldImport(orderValue = 2,clownNameInCh = "生成年龄",clownName = "generalYear")
    private Integer generalYear;

    private static final long serialVersionUID = 1L;

    public static final String COL_NAME = "name";

    public static final String COL_AGE = "age";
}