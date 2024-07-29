package com.zmh.domain.goods.model.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description: SeckillProductsPO 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:35
 */
@Data
public class SeckillGoodsPO {

    /**
     * 秒杀商品ID
     */
    private Long seckillGoodsId;

    /**
     * 商品ID
     */
    private Long goodsId;

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
