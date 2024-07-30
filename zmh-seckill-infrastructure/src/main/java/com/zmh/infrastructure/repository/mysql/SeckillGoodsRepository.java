package com.zmh.infrastructure.repository.mysql;

import com.alibaba.fastjson2.JSON;
import com.zmh.domain.goods.model.aggregates.SeckillGoodsAggregates;
import com.zmh.domain.goods.model.entity.GoodsEntity;
import com.zmh.domain.goods.model.entity.SeckillGoodsEntity;
import com.zmh.domain.goods.repository.ISeckillGoodsRepository;
import com.zmh.infrastructure.converter.ToGoodsEntity;
import com.zmh.infrastructure.converter.ToSeckillGoodsEntity;
import com.zmh.infrastructure.dao.GoodsDao;
import com.zmh.infrastructure.dao.SeckillGoodsDao;
import com.zmh.infrastructure.po.SeckillGoodsPO;
import com.zmh.infrastructure.utils.redis.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: SeckillGoodsRepository
 * @author: zhou ming hao
 * @date: 2024年07月31日 0:28
 */
@Repository
@RequiredArgsConstructor
public class SeckillGoodsRepository implements ISeckillGoodsRepository {

    private final GoodsDao goodsDao;

    private final SeckillGoodsDao seckillGoodsDao;

    private final RedisUtil redisUtil;


    @Override
    public List<SeckillGoodsAggregates> getSeckillGoodsAggregates(Integer pageNum, Integer limit) {

        RowBounds rowBounds = new RowBounds((pageNum - 1) * limit, limit);

        List<SeckillGoodsPO> seckillGoodsPOList = seckillGoodsDao.querySeckillGoodsList(rowBounds);
        List<SeckillGoodsEntity> seckillGoodsEntityList = ToSeckillGoodsEntity.INSTANCE.toList(seckillGoodsPOList);
        Map<Long, SeckillGoodsAggregates> seckillGoodsAggregatesMap = seckillGoodsEntityList.stream().map(this::buildSeckillGoodsAggregates)
                .collect(Collectors.toMap(SeckillGoodsAggregates::getGoodsId, Function.identity()));
        List<GoodsEntity> goodsEntityList = ToGoodsEntity.INSTANCE.toList(goodsDao.queryGoodsList(seckillGoodsPOList.stream().map(SeckillGoodsPO::getGoodsId).collect(Collectors.toList())));

        goodsEntityList.forEach(goodsEntity -> {
            SeckillGoodsAggregates seckillGoodsAggregates = seckillGoodsAggregatesMap.get(goodsEntity.getGoodsId());
            if (seckillGoodsAggregates == null) return;
            seckillGoodsAggregates.setGoods(goodsEntity);
        });
        return new ArrayList<>(seckillGoodsAggregatesMap.values());
    }

    @Override
    public List<SeckillGoodsAggregates> getRedisSeckillGoodsAggregates(String seckillGoodsKey) {

        String seckillListJson = (String) redisUtil.getValue(seckillGoodsKey);

        return JSON.parseArray(seckillListJson, SeckillGoodsAggregates.class);
    }

    @Override
    public void setRedisSeckillGoodsAggregates(String seckillGoodsKey, List<SeckillGoodsAggregates> seckillGoodsAggregatesList) {
        redisUtil.setValueWithExpiry(seckillGoodsKey, JSON.toJSONString(seckillGoodsAggregatesList), 5L, TimeUnit.MINUTES);
    }

    private SeckillGoodsAggregates buildSeckillGoodsAggregates(SeckillGoodsEntity seckillGoods) {
        SeckillGoodsAggregates seckillGoodsAggregates = new SeckillGoodsAggregates();
        seckillGoodsAggregates.setSeckillGoods(seckillGoods);
        seckillGoodsAggregates.setGoodsId(seckillGoods.getGoodsId());
        return seckillGoodsAggregates;
    }
}
