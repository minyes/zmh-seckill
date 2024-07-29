package com.zmh.app.excption;

import com.zmh.app.result.ResultCode;
import lombok.Data;

/**
 * @Description: SeckillExcption
 * @author: zhou ming hao
 * @date: 2024年07月28日 17:27
 */

@Data
public class SeckillException extends RuntimeException{


    /**
     * 响应码
     */
    private String code;

    /**
     * 响应描述
     */
    private String message;



    public SeckillException() {
        super();
    }

    public SeckillException(ResultCode resultCode) {
        super(resultCode.message());
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public SeckillException(ResultCode resultCode, Throwable cause) {
        super(resultCode.message(), cause);
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public SeckillException(String message) {
        super(message);
        this.setCode("999999");
        this.message = message;
    }

    public SeckillException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SeckillException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
