package com.zmh.app.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: DirectExchangeConfig
 * @author: zhou ming hao
 * @date: 2024年07月27日 18:24
 */
@Configuration
public class DirectExchangeConfig {

    //定义队列的名称常量
    public static final String DIRECT_QUEUE = "directQueue";
    public static final String DIRECT_QUEUE2 = "directQueue2";
    //定义直接交换机的名称常量
    public static final String DIRECT_EXCHANGE = "directExchange";
    //定义路由键常量，用于交换机和队列之间的绑定
    public static final String DIRECT_ROUTING_KEY = "direct";

    public static final String DIRECT_SECKILL_ROUTING_KEY2 = "SeckillOrder";

    //定义队列，名称为DIRECT_QUEUE
    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE, true);
    }

    //定义队列，名称为DIRECT_QUEUE2
    @Bean
    public Queue directQueue2() {
        return new Queue(DIRECT_QUEUE2, true);
    }

    //定义直接交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    //定义一个绑定，将directQueue队列绑定到directExchange交换机上，
    //使用direct作为路由键
    @Bean
    public Binding bindingDirectExchange(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(DIRECT_ROUTING_KEY);
    }

    // 定义一个绑定Bean，将directQueue2队列也绑定到directExchange交换机上，
    // 同样使用direct作为路由键
    @Bean
    public Binding bindingDirectExchange2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(DIRECT_ROUTING_KEY);
    }

    /**
     * 设置秒杀路由键  并绑定队列和交换机
     * @param directQueue2
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingDirectExchange3(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(DIRECT_SECKILL_ROUTING_KEY2);
    }

}
