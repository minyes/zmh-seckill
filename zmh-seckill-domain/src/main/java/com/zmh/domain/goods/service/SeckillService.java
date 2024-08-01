package com.zmh.domain.goods.service;

import com.zmh.app.excption.SeckillException;
import com.zmh.app.result.ResultCode;
import com.zmh.domain.goods.model.entity.DoSeckillEntity;
import com.zmh.domain.goods.repository.ISeckillCacheRepository;
import com.zmh.domain.goods.repository.ISeckillMQMessageRepository;
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

    private ISeckillMQMessageRepository seckillMQMessageRepository;

    /**
     * 秒杀商品
     * @param doSeckillEntity
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doSeckil(DoSeckillEntity doSeckillEntity) {

        // 判断内存中 内存中库存标识是否为 true有库存  false没库存 直接返回失败
        Boolean flag = stock_flag.get(doSeckillEntity.getSeckillGoodsId());
        if(flag != null && !flag){
            throw new SeckillException(ResultCode.UNDER_STOCK);
        }

        // 抢库存  redis 扣减库存
        Long stock = seckillCacheRepository.rebateStock(doSeckillEntity.getSeckillGoodsId());

        if(stock < 0){
            //库存异常
            throw new SeckillException(ResultCode.UNDER_STOCK);
        }

        // 设置库存内存标识
        if(stock == 0){
            stock_flag.put(doSeckillEntity.getSeckillGoodsId(),false);
        }else {
            stock_flag.put(doSeckillEntity.getSeckillGoodsId(),true);
        }

        // 调mq 异步下单
        seckillMQMessageRepository.placeOrder(doSeckillEntity);


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
