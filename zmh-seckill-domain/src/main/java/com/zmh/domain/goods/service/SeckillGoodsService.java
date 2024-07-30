package com.zmh.domain.goods.service;

import com.zmh.domain.goods.model.aggregates.SeckillGoodsAggregates;
import com.zmh.domain.goods.repository.ISeckillGoodsRepository;
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

    private static final String seckillGoodsKey = "seckillGoodsKey";

    @Override
    public List<SeckillGoodsAggregates> getSeckillGoodsList(Integer pageNum, Integer limit) {
        // 判断当前页是否为前三页 是 从redis拿  不是 从库里拿并缓存到redis中
        if (pageNum < 4) {
            List<SeckillGoodsAggregates> seckillGoodsAggregatesList
                    = seckillGoodsRepository.getRedisSeckillGoodsAggregates(seckillGoodsKey + pageNum);
            if (!CollectionUtils.isEmpty(seckillGoodsAggregatesList)) {
                return seckillGoodsAggregatesList;
            }
            // 查询秒杀商品
            List<SeckillGoodsAggregates> querySeckillGoodsAggregatesList
                    = seckillGoodsRepository.getSeckillGoodsAggregates(pageNum, limit);

            if (CollectionUtils.isEmpty(querySeckillGoodsAggregatesList)) {
                return querySeckillGoodsAggregatesList;
            }
            // 缓存到redis中 五分钟失效
            seckillGoodsRepository
                    .setRedisSeckillGoodsAggregates(seckillGoodsKey + pageNum, querySeckillGoodsAggregatesList);
            return querySeckillGoodsAggregatesList;

        }
        // 当前页不是前三页 从库中取
        return seckillGoodsRepository.getSeckillGoodsAggregates(pageNum, limit);
    }

}
