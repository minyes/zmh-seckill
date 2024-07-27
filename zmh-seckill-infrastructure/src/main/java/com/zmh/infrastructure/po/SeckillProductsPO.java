package com.zmh.infrastructure.po;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description: SeckillProductsPO 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:35
 */
@Data
public class SeckillProductsPO {

    /**
     * 秒杀商品ID
     */
    private Long seckillProductId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 秒杀价格
     */
    private String seckillPrice;

    /**
     * 秒杀开始时间
     */
    private LocalDate startTime;

    /**
     * 秒杀结束时间
     */
    private LocalDate endTime;

    /**
     * 秒杀库存数量
     */
    private Long stock;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;
}
