package com.zmh.domain.order.model.aggregates;

import com.zmh.domain.order.model.entity.GoodsEntity;
import com.zmh.domain.order.model.entity.SeckillGoodsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: SeckillGoodsAggregates
 * @author: zhou ming hao
 * @date: 2024年07月31日 1:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeckillGoodsAggregates {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品信息
     */
    private GoodsEntity goods;

    /**
     * 商品秒杀信息
     */
    private SeckillGoodsEntity seckillGoods;
}
