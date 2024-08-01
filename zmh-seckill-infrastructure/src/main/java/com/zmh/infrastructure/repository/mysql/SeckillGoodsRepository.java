package com.zmh.infrastructure.repository.mysql;

import com.zmh.domain.order.model.aggregates.SeckillGoodsAggregates;
import com.zmh.domain.order.model.entity.GoodsEntity;
import com.zmh.domain.order.model.entity.SeckillGoodsEntity;
import com.zmh.domain.order.repository.ISeckillGoodsRepository;
import com.zmh.infrastructure.converter.ToGoodsEntity;
import com.zmh.infrastructure.converter.ToSeckillGoodsEntity;
import com.zmh.infrastructure.dao.GoodsDao;
import com.zmh.infrastructure.dao.SeckillGoodsDao;
import com.zmh.infrastructure.po.GoodsPO;
import com.zmh.infrastructure.po.SeckillGoodsPO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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



    /**
     * 查询 秒杀信息和商品信息
     *
     * @param pageNum
     * @param limit
     * @return
     */
    @Override
    public List<SeckillGoodsAggregates> getSeckillGoodsAggregatesList(Integer pageNum, Integer limit) {

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

    /**
     * 获取秒杀信息
     *
     * @param SeckillGoodsId
     * @return
     */
    @Override
    public SeckillGoodsAggregates getSeckillGoodsAggregates(Long SeckillGoodsId) {

        SeckillGoodsPO seckillGoodsPO = seckillGoodsDao.uerySeckillGoodsBySeckillGoodsId(SeckillGoodsId);
        GoodsPO goods = goodsDao.queryGoodsByGoodsId(seckillGoodsPO.getGoodsId());

        return SeckillGoodsAggregates.builder().goodsId(seckillGoodsPO.getGoodsId())
                .seckillGoods(ToSeckillGoodsEntity.INSTANCE.convert(seckillGoodsPO))
                .goods(ToGoodsEntity.INSTANCE.convert(goods)).build();
    }

    private SeckillGoodsAggregates buildSeckillGoodsAggregates(SeckillGoodsEntity seckillGoods) {
        SeckillGoodsAggregates seckillGoodsAggregates = new SeckillGoodsAggregates();
        seckillGoodsAggregates.setSeckillGoods(seckillGoods);
        seckillGoodsAggregates.setGoodsId(seckillGoods.getGoodsId());
        return seckillGoodsAggregates;
    }
}
