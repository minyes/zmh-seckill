package com.zmh.trigger.http.cmd;

import com.zmh.trigger.http.dto.req.PaySeckillOrderReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;

/**
 * @Description: ISeckillOrderCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:41
 */

public interface ISeckillOrderCommand {

    /**
     * 获取订单信息
     * @param seckillOrderId
     * @return
     */
    QuerySeckillOrderRespDTO getSeckillOrder(Long seckillOrderId);

    /***
     * 支付订单
     * @param paySeckillOrderReqDTO
     * @param seckillOrderId
     */
    void paySeckillOrder(PaySeckillOrderReqDTO paySeckillOrderReqDTO, Long seckillOrderId);

}
