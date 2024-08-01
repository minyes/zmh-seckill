package com.zmh.domain.order.service;

import com.zmh.app.excption.SeckillException;
import com.zmh.app.result.ResultCode;
import com.zmh.app.utils.SnowFlakeUtil;
import com.zmh.domain.order.model.aggregates.CreateSeckillOrdersAggregate;
import com.zmh.domain.order.model.entity.*;
import com.zmh.domain.order.model.valobj.OrderStatus;
import com.zmh.domain.order.repository.ISeckillOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: OrderService
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:50
 */
@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final ISeckillOrderRepository seckillOrderRepository;

    /**
     * 下单
     */
    @Transactional
    @Override
    public void placeOrder(PlaceOrderEntity placeOrder) {
        // 判断是否重复下单
        SeckillOrdersEntity seckillOrdersEntity = seckillOrderRepository.querySeckillOrder(placeOrder.getUserId(), placeOrder.getGoodsId());
        if (seckillOrdersEntity != null) {
            throw new SeckillException(ResultCode.REPEAT_ORDER);
        }

        SeckillGoodsEntity seckillGoods = seckillOrderRepository.querySeckillGoods(placeOrder.getSeckillGoodsId());
        Long orderId = SnowFlakeUtil.getDefaultSnowFlakeId();

        OrdersEntity ordersEntity = OrdersEntity.builder().orderId(orderId)
                .orderStatus(OrderStatus.PENDING.getCode())
                .totalAmount(seckillGoods.getSeckillPrice())
                .userId(placeOrder.getUserId()).build();

        SeckillOrdersEntity seckillOrders = SeckillOrdersEntity.builder().orderId(orderId)
                .seckillOrderId(SnowFlakeUtil.getDefaultSnowFlakeId())
                .userId(placeOrder.getUserId())
                .seckillGoodsId(seckillGoods.getSeckillGoodsId()).build();

        //下订单
        seckillOrderRepository.createSeckillOrder(CreateSeckillOrdersAggregate.builder().orders(ordersEntity).seckillOrders(seckillOrders).build());
    }


}
