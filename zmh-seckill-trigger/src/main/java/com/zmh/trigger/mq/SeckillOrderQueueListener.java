package com.zmh.trigger.mq;

import com.zmh.app.mq.DirectExchangeConfig;
import com.zmh.trigger.http.cmd.ISeckillOrderCommand;
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


    private final ISeckillOrderCommand seckillOrderCommand;

    /**
     * 秒杀订单消费消息
     * @param testMessage
     */
    @RabbitHandler
    @RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE)
    public void process(String testMessage) {
        System.out.println("DirectReceiver消费者收到消息1  : " + testMessage + "\n");


    }


}
