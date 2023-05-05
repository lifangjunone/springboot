package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(10000, "success", new HashMap<>());
    }

    public static Result success(Object data) {
        return new Result(10000, "success", data);
    }

    public static Result error(String msg) {
        return new Result(10002, msg, new HashMap<>());
    }

    public static Result permissionDenied() {
        return new Result(10003, "permission denied", new HashMap<>());
    }

    public static Result notLogin() {
        return new Result(10004, "please login in !!!", new HashMap<>());
    }
}
