package com.zmh.domain.order.model.entity;

import lombok.Data;

/**
 * @Description: PlaceOrderEntity
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:52
 */
@Data
public class PlaceOrderEntity {

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
