package com.zmh.application.cmd.seckill;

import com.alibaba.fastjson2.JSON;
import com.zmh.domain.order.model.entity.PlaceOrderEntity;
import com.zmh.domain.order.service.IOrderService;
import com.zmh.trigger.mq.cmd.IOrdersCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description: OrdersCommand
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:48
 */
@Component
@RequiredArgsConstructor
public class OrdersCommand implements IOrdersCommand {

    private final IOrderService orderService;

    @Override
    public void placeOrder(String message) {
        orderService.placeOrder(JSON.parseObject(message, PlaceOrderEntity.class));
    }
}
