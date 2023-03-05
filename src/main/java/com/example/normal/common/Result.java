package com.example.normal.common;


import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

@Data
public class Result {

    private Integer errCode;

    private Object data;

    private String msg;

}
