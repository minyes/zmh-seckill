package com.zmh.application.cmd.seckill.impl;

import com.zmh.application.cmd.seckill.ISeckillCommand;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import org.springframework.stereotype.Component;

/**
 * @Description: SeckillCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:35
 */
@Component
public class SeckillCommand implements ISeckillCommand {


    @Override
    public void doSeckill(DoSeckillReqDTO doSeckillReqDTO, Long seckillGoodsId) {
        // 判断内存中 内存中库存标识是否为 true有库存  false没库存 直接返回失败

        // 抢库存  令牌桶 从redis 中获取库存

        // 判断库存是否大于0 并进行预扣减 库存

        // 判断 库存小于0  设置内存标识为false

        // 调mq 异步下单


    }
}
