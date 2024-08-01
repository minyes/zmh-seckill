package com.zmh.domain.order.repository;

import com.zmh.domain.order.model.aggregates.CreateSeckillOrdersAggregate;
import com.zmh.domain.order.model.entity.SeckillGoodsEntity;
import com.zmh.domain.order.model.entity.SeckillOrdersEntity;

/**
 * @Description: ISeckillOrderRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 21:08
 */

public interface ISeckillOrderRepository {

    SeckillOrdersEntity querySeckillOrder(Long userId, Long orderId);

    void createSeckillOrder(CreateSeckillOrdersAggregate createSeckillOrdersAggregate);

    SeckillGoodsEntity querySeckillGoods(Long seckillGoodsId);
}
