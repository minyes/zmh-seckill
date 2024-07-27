package com.zmh.infrastructure.po;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description: OrdersPO 订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:56
 */
@Data
public class OrdersPO {
    private Long orderId;

    private Long userId;

    private BigDecimal totalPrice;

    /**
     *
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;
}
