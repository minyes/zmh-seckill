package com.zmh.trigger.http.cmd;

import com.zmh.trigger.http.dto.req.PaySeckillOrderReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;

/**
 * @Description: ISeckillOrderCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:41
 */

public interface ISeckillOrderCommand {

    QuerySeckillOrderRespDTO getSeckillOrder(Long seckillOrderId);

    void paySeckillOrder(PaySeckillOrderReqDTO paySeckillOrderReqDTO, Long seckillOrderId);
}
