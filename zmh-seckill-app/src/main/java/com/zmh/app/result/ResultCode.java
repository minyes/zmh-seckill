package com.zmh.app.result;

/**
 * @Description: ResultCode
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:20
 *
 * 响应码规范
 * （1）1到2位是系统码字母缩写标识  秒杀系统  SK
 * （2）第3位是 区分 系统异常和业务异常  1是系统异常 2是业务异常
 * （3）第4到第6位 根据定义递增
 *
 */

public enum ResultCode {

    SUCCESS("SK1001", "成功"),
    PARAM_IS_INVALID("SK1002", "参数无效"),
    PARAM_IS_BLANK("SK1003", "参数为空"),
    PARAM_TYPE_BIND_ERROR("SK1004", "参数类型错误"),
    SYSTEM_ERROR("SK1999","系统出现异常"),

    UNDER_STOCK("SK2001","库存不足");

    private String code;
    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }
    public String message() {
        return this.message;
    }
}
