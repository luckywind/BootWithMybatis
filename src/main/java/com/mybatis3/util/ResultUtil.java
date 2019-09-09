package com.mybatis3.util;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setErrorCode("1");
        result.setErrorMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setErrorCode(code);
        result.setErrorMsg(msg);
        return result;
    }
    public static Result error(String msg) {
        Result result = new Result();
        result.setErrorMsg(msg);
        return result;
    }
}
