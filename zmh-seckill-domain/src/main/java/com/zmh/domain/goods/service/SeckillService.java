package com.zmh.domain.goods.service;

import com.zmh.app.excption.SeckillException;
import com.zmh.app.result.ResultCode;
import com.zmh.domain.goods.model.entity.DoSeckillEntity;
import com.zmh.domain.goods.repository.ISeckillCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SeckillService
 * @author: zhou ming hao
 * @date: 2024年08月01日 15:04
 */
@Service
@RequiredArgsConstructor
public class SeckillService implements ISeckillService, InitializingBean {

    private static Map<Long,Boolean> stock_flag = new HashMap<>();

    private ISeckillCacheRepository seckillCacheRepository;


    /**
     * 秒杀商品
     * @param seckillEntity
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doSeckil(DoSeckillEntity seckillEntity) {
        //判断是否重复抢购 落幂等表 强控  userId+goodsId

        // 判断内存中 内存中库存标识是否为 true有库存  false没库存 直接返回失败
        Boolean flag = stock_flag.get(seckillEntity.getSeckillGoodsId());
        if(flag != null && !flag){
            throw new SeckillException(ResultCode.UNDER_STOCK);
        }

        // 抢库存  redis 扣减库存
        Long stock = seckillCacheRepository.rebateStock(seckillEntity.getSeckillGoodsId());

        if(stock < 0){
            //库存异常
            throw new SeckillException(ResultCode.UNDER_STOCK);
        }

        // 设置库存内存标识
        if(stock == 0){
            stock_flag.put(seckillEntity.getSeckillGoodsId(),false);
        }else {
            stock_flag.put(seckillEntity.getSeckillGoodsId(),true);
        }

        // 调mq 异步下单



    }



    /**
     * 初始化库存 放入到redis中
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        seckillCacheRepository.cacheStock();
    }
}
