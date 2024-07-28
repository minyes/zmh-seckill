package com.zmh.application.cmd;

import com.zmh.trigger.http.cmd.ISeckillCommand;
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

    }
}
