package com.zmh.domain.goods.service;

import com.zmh.domain.goods.model.aggregates.SeckillGoodsAggregates;

import java.util.List;

/**
 * @Description: ISeckillGoodsService
 * @author: zhou ming hao
 * @date: 2024年07月30日 15:03
 */

public interface ISeckillGoodsService {


    List<SeckillGoodsAggregates> getSeckillGoodsList(Integer pageNum, Integer limit);


    SeckillGoodsAggregates querySeckillGoodsDetails(Long seckillGoodsId);

}
