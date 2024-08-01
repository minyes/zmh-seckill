package com.zmh.application.cmd.seckill;

import com.zmh.application.converter.ToQuerySeckillGoodsRespDTO;
import com.zmh.domain.order.service.IOrderService;
import com.zmh.trigger.http.cmd.ISeckillOrderCommand;
import com.zmh.trigger.http.dto.req.PaySeckillOrderReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description: SeckillOrderCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:41
 */
@Component
@RequiredArgsConstructor
public class SeckillOrderCommand implements ISeckillOrderCommand {

    private final IOrderService orderService;

    /**
     * 查询秒杀订单
     * @param seckillOrderId
     * @return
     */
    @Override
    public QuerySeckillOrderRespDTO getSeckillOrder(Long seckillOrderId) {
        // 查询秒杀订单表 获取订单
        return ToQuerySeckillGoodsRespDTO.INSTANCE.convert(orderService.getOrder(seckillOrderId));
    }

    @Override
    public void paySeckillOrder(PaySeckillOrderReqDTO paySeckillOrderReqDTO, Long seckillOrderId) {
        //进行支付 成功
    }
}
