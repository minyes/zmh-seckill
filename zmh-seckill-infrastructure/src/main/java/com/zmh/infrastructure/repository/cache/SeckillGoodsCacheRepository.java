package com.zmh.infrastructure.repository.cache;

import com.alibaba.fastjson2.JSON;
import com.zmh.domain.goods.model.aggregates.SeckillGoodsAggregates;
import com.zmh.domain.goods.repository.ISeckillGoodsCacheRepository;
import com.zmh.infrastructure.utils.redis.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: SeckillGoodsCacheRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:42
 */
@Repository
@RequiredArgsConstructor
public class SeckillGoodsCacheRepository implements ISeckillGoodsCacheRepository {

    private final RedisUtil redisUtil;


    /**
     * 从redis中拿到 秒杀商品信息
     *
     * @param seckillGoodsKey
     * @return
     */
    @Override
    public List<SeckillGoodsAggregates> getRedisSeckillGoodsAggregates(String seckillGoodsKey) {

        String seckillListJson = (String) redisUtil.getValue(seckillGoodsKey);

        return JSON.parseArray(seckillListJson, SeckillGoodsAggregates.class);
    }

    /**
     * 将秒杀信息列表缓存到redis中
     *
     * @param seckillGoodsKey
     * @param seckillGoodsAggregatesList
     */
    @Override
    public void setRedisSeckillGoodsAggregates(String seckillGoodsKey, List<SeckillGoodsAggregates> seckillGoodsAggregatesList) {
        redisUtil.setValueWithExpiry(seckillGoodsKey, JSON.toJSONString(seckillGoodsAggregatesList), 5L, TimeUnit.MINUTES);
    }
}
