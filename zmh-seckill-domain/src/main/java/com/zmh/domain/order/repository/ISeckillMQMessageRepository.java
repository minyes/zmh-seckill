package com.zmh.domain.order.repository;

import com.zmh.domain.order.model.entity.DoSeckillEntity;

/**
 * @Description: ISeckillMQMessageRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:10
 */

public interface ISeckillMQMessageRepository {

    void placeOrder(DoSeckillEntity seckillEntity);

}
