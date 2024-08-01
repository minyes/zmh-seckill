package com.zmh.domain.goods.repository;

import com.zmh.domain.goods.model.aggregates.SeckillGoodsAggregates;

import java.util.List;

/**
 * @Description: ISeckillGoodsRepository
 * @author: zhou ming hao
 * @date: 2024年07月31日 0:14
 */

public interface ISeckillGoodsRepository {

    List<SeckillGoodsAggregates> getSeckillGoodsAggregatesList(Integer pageNum, Integer limit);

    SeckillGoodsAggregates getSeckillGoodsAggregates(Long SeckillGoodsId);
}
