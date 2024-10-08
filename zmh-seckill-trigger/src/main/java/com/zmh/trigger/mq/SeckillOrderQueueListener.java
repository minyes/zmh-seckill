package com.zmh.trigger.mq;

import com.zmh.app.mq.DirectExchangeConfig;
import com.zmh.trigger.mq.cmd.IOrdersCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description: DirectQueueListener
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:24
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SeckillOrderQueueListener {


    private final IOrdersCommand ordersCommand;

    /**
     * 秒杀订单消费消息
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE)
    public void process(String message) {
        System.out.println("DirectReceiver消费者收到消息  : " + message + "\n");
        ordersCommand.placeOrder(message);
    }


}
