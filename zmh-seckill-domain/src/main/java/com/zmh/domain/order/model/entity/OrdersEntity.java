package com.zmh.domain.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description: OrdersPO 订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersEntity {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单金额
     */
    private BigDecimal totalAmount;

    /**
     * 订单状态
     */
    private String orderStatus;

}
