package com.zmh.infrastructure.utils.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: DirectMqUtil
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:33
 */
@Component
public class DirectMqUtil {
    private final RabbitTemplate rabbitTemplate;

    public DirectMqUtil(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     * direct交换机为直连模式交换机
     * 根据消息携带的路由键将消息投递给对应队列
     *
     *
     * @return
     */
    @GetMapping("send")
    public Object sendMsg(String exchange,String routingKey,String msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        return "direct消息发送成功！！";
    }
}
