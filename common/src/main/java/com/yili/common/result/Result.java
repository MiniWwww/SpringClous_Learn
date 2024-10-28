package com.yili.common.result;


import lombok.Data;


/**
 * 统一结果集
 * @param <T>
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> build(ResultEnum resultEnum, T data) {
        Result<T> result = new Result<T>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static <T> Result<T> build(ResultEnum resultEnum) {
        Result<T> result = new Result<T>();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static <T> Result<T> build(Integer code,String message, T data) {
        Result<T> result = new Result<T>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> ok(String message) {
        return build(ResultEnum.SUCCESS.getCode(),message,null);
    }
    public static <T> Result<T> ok(String message,T data) {
        return build(ResultEnum.SUCCESS.getCode(),message,data);
    }
    public static <T> Result<T> ok( T data) {
       return build(ResultEnum.SUCCESS,data);
    }

    public static <T> Result<T> fail( T data) {
        return build(ResultEnum.FAIL,data);
    }
    public static <T> Result<T> fail( String message) {
        return build(ResultEnum.FAIL.getCode(),message,null);
    }




}
