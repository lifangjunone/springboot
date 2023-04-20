package com.itheima.resp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Boolean isSuccess;
    private Integer code;
    private Long timestamp;
    private Object data;
    private String msg;

    public Result(Boolean isSuccess, Integer code, Long timestamp, Object data, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.timestamp = timestamp;
        this.data = data;
        this.msg = msg;
    }

    static HashMap<String, String> defaultData() {
        return new HashMap<>(0);
    }

    // 成功没有数据
    public static Result getReturn() {
        return new Result(true, 10000, System.currentTimeMillis(), defaultData(), "");
    }

    // 成功对象数据返回
    public static Result getReturn(Object data) {
        return new Result(true, 10000, System.currentTimeMillis(), data, "");
    }

    // 成功列表数据返回
    public static Result getReturn(List<?> data) {
        return new Result(true, 10000, System.currentTimeMillis(), data, "");
    }

    // 失败数据返回
    public static Result getReturn(String msg) {
        return new Result(true, 10001, System.currentTimeMillis(), defaultData(), msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
