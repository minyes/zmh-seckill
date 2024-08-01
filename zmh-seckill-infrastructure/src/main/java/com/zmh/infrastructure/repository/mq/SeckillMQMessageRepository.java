package com.zmh.infrastructure.repository.mq;

import com.alibaba.fastjson2.JSON;
import com.zmh.app.mq.DirectExchangeConfig;
import com.zmh.domain.order.model.entity.DoSeckillEntity;
import com.zmh.domain.order.repository.ISeckillMQMessageRepository;
import com.zmh.infrastructure.utils.mq.DirectMqUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Description: SeckillMQMessageRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:11
 */
@Repository
@RequiredArgsConstructor
public class SeckillMQMessageRepository implements ISeckillMQMessageRepository {


    private final DirectMqUtil directMqUtil;

    /**
     * 发送到MQ 队列 后续下单
     * @param seckillEntity
     */
    @Override
    public void placeOrder(DoSeckillEntity seckillEntity) {
        directMqUtil.sendMsg(DirectExchangeConfig.DIRECT_EXCHANGE, DirectExchangeConfig.DIRECT_SECKILL_ROUTING_KEY2, JSON.toJSONString(seckillEntity));
    }
}
