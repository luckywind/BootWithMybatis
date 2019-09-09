package com.mybatis3.util;

import org.springframework.web.bind.annotation.RestController;

public final class Result<T> {
    private int status = 1;
    private String errorCode = "";
    private String errorMsg = "";
    private T data;

    public Result() {

    }
    public Result(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
