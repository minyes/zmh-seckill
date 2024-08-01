package com.zmh.domain.goods.model.entity;

import lombok.Data;

/**
 * @Description: SeckillEntity
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:08
 */
@Data
public class DoSeckillEntity {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 秒杀商品id
     */
    private Long seckillGoodsId;
}
