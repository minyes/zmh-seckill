package com.zmh.application.cmd.seckill;

import com.zmh.trigger.http.cmd.ISeckillOrderCommand;
import com.zmh.trigger.http.dto.req.PaySeckillOrderReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;
import org.springframework.stereotype.Component;

/**
 * @Description: SeckillOrderCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:41
 */
@Component
public class SeckillOrderCommand implements ISeckillOrderCommand {

    @Override
    public void downOrder() {
        // 判断 库中是否有库存 没有 下单失败
        // 下单
    }

    /**
     *
     * @param seckillOrderId
     * @return
     */

    @Override
    public QuerySeckillOrderRespDTO getSeckillOrder(Long seckillOrderId) {
        // 查询秒杀订单表 获取订单
        return null;
    }

    @Override
    public void paySeckillOrder(PaySeckillOrderReqDTO paySeckillOrderReqDTO, Long seckillOrderId) {
        //进行支付 成功
    }
}
