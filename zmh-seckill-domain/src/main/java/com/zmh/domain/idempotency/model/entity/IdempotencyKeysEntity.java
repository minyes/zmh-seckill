package com.zmh.domain.idempotency.model.entity;

import com.zmh.app.excption.SeckillException;
import com.zmh.app.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @Description: IdempotencyKeysPO
 * @author: zhou ming hao
 * @date: 2024年07月29日 23:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdempotencyKeysEntity {

    /**
     * 幂等性键
     */
    private String idempotencyKey;

    /**
     * 请求数据
     */
    private String requestPayload;

    /**
     * 响应数据
     */
    private String responsePayload;

    /**
     * 交易码
     */
    private String transCode;

    public void checkIdempotencyKey(){
        if(StringUtils.isEmpty(idempotencyKey))throw new SeckillException(ResultCode.IDEMPOTENCY_KEY_IS_NULL);
    }
}
