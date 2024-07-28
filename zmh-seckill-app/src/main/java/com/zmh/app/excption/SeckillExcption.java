package com.zmh.app.excption;

import com.zmh.app.result.ResultCode;
import lombok.Data;

/**
 * @Description: SeckillExcption
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:27
 */

@Data
public class SeckillExcption extends RuntimeException{


    /**
     * 响应码
     */
    private String code;

    /**
     * 响应描述
     */
    private String message;



    public SeckillExcption() {
        super();
    }

    public SeckillExcption(ResultCode resultCode) {
        super(resultCode.message());
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public SeckillExcption(ResultCode resultCode, Throwable cause) {
        super(resultCode.message(), cause);
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public SeckillExcption(String message) {
        super(message);
        this.setCode("999999");
        this.message = message;
    }

    public SeckillExcption(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SeckillExcption(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
