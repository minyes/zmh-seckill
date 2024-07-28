package com.zmh.application.cmd;

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
    public QuerySeckillOrderRespDTO getSeckillOrder(Long seckillOrderId) {
        return null;
    }

    @Override
    public void paySeckillOrder(PaySeckillOrderReqDTO paySeckillOrderReqDTO, Long seckillOrderId) {

    }
}
