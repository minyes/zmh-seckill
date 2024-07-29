package com.zmh.infrastructure.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description: IdempotencyKeysPO
 * @author: zhou ming hao
 * @date: 2024年07月29日 23:56
 */
@Data
public class IdempotencyKeysPO {
    /**
     * 主键id
     */
    private Long id;

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
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;
}
