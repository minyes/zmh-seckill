package com.zmh.domain.order.model.aggregates;

import com.zmh.domain.order.model.entity.OrdersEntity;
import com.zmh.domain.order.model.entity.SeckillOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: CreateSeckillOrdersAggregate
 * @author: zhou ming hao
 * @date: 2024年07月29日 23:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSeckillOrdersAggregate {

    /**
     * 订单信息
     */
    private OrdersEntity orders;

    /**
     * 秒杀订单信息
     */
    private SeckillOrdersEntity seckillOrders;
}
