package com.zmh.domain.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: SeckillOrders 秒杀订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeckillOrdersEntity {

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

}
