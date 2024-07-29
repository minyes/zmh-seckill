package com.zmh.app.aspect;

/**
 * @Description: GlobalExceptionHandler
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:16
 */

import com.zmh.app.excption.SeckillException;
import com.zmh.app.result.Result;
import com.zmh.app.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * 全局异常处理类
 * @RestControllerAdvice(@ControllerAdvice)，拦截异常并统一处理
 * @author sw-code
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param e    异常对象
     * @param request    request
     * @return    错误结果
     */
    @ExceptionHandler(SeckillException.class)
    public Result bizExceptionHandler(SeckillException e, HttpServletRequest request) {
        log.error("发生业务异常！原因是: {}", e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    // 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public Result handlerThrowable(Throwable e, HttpServletRequest request) {
        log.error("发生未知异常！原因是: ", e);
        return Result.fail(ResultCode.SYSTEM_ERROR, e);
    }

    // 参数校验异常
    @ExceptionHandler(BindException.class)
    public Result handleBindExcpetion(BindException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：",e);
        return Result.fail(ResultCode.PARAM_IS_INVALID, e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：",e);
        return Result.fail(ResultCode.PARAM_IS_INVALID,e);
    }
}
