package com.zmh.domain.order.repository;

/**
 * @Description: ISeckillCacheRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:48
 */

public interface ISeckillCacheRepository {

    /**
     * 扣减库存
     * @param seckillGoodsId
     * @return
     */
    Long rebateStock(Long seckillGoodsId);

    void cacheStock();
}
