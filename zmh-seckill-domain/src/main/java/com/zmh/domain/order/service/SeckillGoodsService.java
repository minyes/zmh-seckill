package com.zmh.domain.order.service;

import com.zmh.domain.order.model.aggregates.SeckillGoodsAggregates;
import com.zmh.domain.order.repository.ISeckillGoodsCacheRepository;
import com.zmh.domain.order.repository.ISeckillGoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: SeckillGoodsService
 * @author: zhou ming hao
 * @date: 2024年07月30日 15:29
 */
@Service
@RequiredArgsConstructor
public class SeckillGoodsService implements ISeckillGoodsService {


    private final ISeckillGoodsRepository seckillGoodsRepository;

    private final ISeckillGoodsCacheRepository seckillGoodsCacheRepository;

    private static final String seckillGoodsKey = "seckillGoodsKey";

    @Override
    public List<SeckillGoodsAggregates> getSeckillGoodsList(Integer pageNum, Integer limit) {
        // 判断当前页是否为前三页 是 从redis拿  不是 从库里拿并缓存到redis中
        if (pageNum < 4) {
            List<SeckillGoodsAggregates> seckillGoodsAggregatesList
                    = seckillGoodsCacheRepository.getRedisSeckillGoodsAggregates(seckillGoodsKey + pageNum);
            if (!CollectionUtils.isEmpty(seckillGoodsAggregatesList)) {
                return seckillGoodsAggregatesList;
            }
            // 查询秒杀商品
            List<SeckillGoodsAggregates> querySeckillGoodsAggregatesList
                    = seckillGoodsRepository.getSeckillGoodsAggregatesList(pageNum, limit);

            if (CollectionUtils.isEmpty(querySeckillGoodsAggregatesList)) {
                return querySeckillGoodsAggregatesList;
            }
            // 缓存到redis中 五分钟失效
            seckillGoodsCacheRepository
                    .setRedisSeckillGoodsAggregates(seckillGoodsKey + pageNum, querySeckillGoodsAggregatesList);
            return querySeckillGoodsAggregatesList;

        }
        // 当前页不是前三页 从库中取
        return seckillGoodsRepository.getSeckillGoodsAggregatesList(pageNum, limit);
    }

    @Override
    public SeckillGoodsAggregates querySeckillGoodsDetails(Long seckillGoodsId) {
        return seckillGoodsRepository.getSeckillGoodsAggregates(seckillGoodsId);
    }

}
