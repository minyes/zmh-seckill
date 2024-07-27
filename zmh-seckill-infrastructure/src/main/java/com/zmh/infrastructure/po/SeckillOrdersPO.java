package com.zmh.infrastructure.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description: SeckillOrders 秒杀订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:39
 */
@Data
public class SeckillOrdersPO {

    /**
     * 秒杀订单id
     */
    private Long seckillOrderId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 秒杀商品ID
     */
    private Long seckillProductId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 状态
     */
    private String status;

    /***
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;
}
