package com.zmh.app.result;

import lombok.Data;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: ResponseResult
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:01
 */
@Data
public class Result<T> {
    /**
     * 响应状态码，200是正常，非200表示异常
     */
    private int status;
    /**
     * 异常编号
     */
    private String errorCode;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public static <T> Result<T> success() {
        return success(HttpServletResponse.SC_OK, null, null);
    }

    public static <T> Result<T> success(T data) {
        return success(HttpServletResponse.SC_OK, null, data);
    }

    public static <T> Result<T> fail(String message) {
        return fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, null, message, null);
    }

    public static <T> Result<T> fail(String errorCode, String message) {
        return fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorCode, message, null);
    }

    public static <T> Result<T> fail(ResultCode resultCode,Throwable e) {
        return fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, resultCode.code(), e.getMessage(), null);
    }

    public static <T> Result<T> success(int status, String message, T data) {
        Result<T> r = new Result<>();
        r.setStatus(status);
        r.setMessage(message);
        r.setData(data);

        return r;
    }

    public static <T> Result<T> fail(int status, String errorCode, String message) {
        return fail(status, errorCode, message, null);
    }

    public static <T> Result<T> fail(int status, String errorCode, String message, T data) {
        Result<T> r = new Result<>();
        r.setStatus(status);
        r.setErrorCode(errorCode);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

}
