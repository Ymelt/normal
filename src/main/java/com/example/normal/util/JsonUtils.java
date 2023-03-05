package com.example.normal.util;

import com.alibaba.fastjson2.JSONObject;
import com.example.normal.common.Result;

public class JsonUtils {

    public static Result success(Object data){
        Result result = new Result();
        result.setMsg("成功");
        result.setErrCode(0);
        result.setData(data);
        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.setMsg("成功");
        result.setErrCode(0);
        return result;
    }


}
