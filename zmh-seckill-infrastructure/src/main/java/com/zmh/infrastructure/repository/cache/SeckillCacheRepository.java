package com.zmh.infrastructure.repository.cache;

import com.zmh.domain.order.repository.ISeckillCacheRepository;
import com.zmh.infrastructure.dao.SeckillGoodsDao;
import com.zmh.infrastructure.po.SeckillGoodsPO;
import com.zmh.infrastructure.utils.redis.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: SeckillCacheRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:54
 */
@Repository
@RequiredArgsConstructor
public class SeckillCacheRepository implements ISeckillCacheRepository {

    private final RedisUtil redisUtil;

    private final SeckillGoodsDao seckillGoodsDao;

    /**
     * 扣减库存
     *
     * @param seckillGoodsId
     * @return 剩余库存
     */
    @Override
    public Long rebateStock(Long seckillGoodsId) {
        return redisUtil.opsForValue().decrement("seckillGoods:" + seckillGoodsId);
    }

    /**
     * 把秒杀订单库存缓存到redis中
     */
    @Override
    public void cacheStock() {
        List<SeckillGoodsPO> seckillGoodsPOList = seckillGoodsDao.querySeckillGoodsAll();
        if (CollectionUtils.isEmpty(seckillGoodsPOList)) return;

        seckillGoodsPOList.forEach(seckillGoodsPO -> {
            redisUtil.opsForValue().set("seckillGoods:" + seckillGoodsPO.getSeckillGoodsId(), seckillGoodsPO.getStock());
        });
    }


}
