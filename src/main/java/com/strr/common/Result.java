package com.strr.common;

public class Result<T>  {
    private Boolean success;

    private String msg;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result<T> success(Boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T> error() {
        return new Result<T>().success(false);
    }

    public static <T> Result<T> ok() {
        return new Result<T>().success(true);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>().success(true).data(data);
    }
}