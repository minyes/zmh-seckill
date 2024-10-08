package com.zmh.domain.order.repository;

import com.zmh.domain.order.model.aggregates.SeckillGoodsAggregates;

import java.util.List;

/**
 * @Description: ISeckillGoodsCacheRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:42
 */

public interface ISeckillGoodsCacheRepository {

    List<SeckillGoodsAggregates> getRedisSeckillGoodsAggregates(String seckillGoodsKey);

    void setRedisSeckillGoodsAggregates(String seckillGoodsKey,List<SeckillGoodsAggregates> seckillGoodsAggregatesList);
}
