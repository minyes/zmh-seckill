package com.zmh.application.cmd.seckill;

import com.zmh.application.converter.ToDoSeckillEntity;
import com.zmh.domain.goods.service.ISeckillService;
import com.zmh.trigger.http.cmd.ISeckillCommand;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description: SeckillCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:35
 */
@Component
@RequiredArgsConstructor
public class SeckillCommand implements ISeckillCommand {

    private final ISeckillService seckillService;

    @Override
    public void doSeckill(DoSeckillReqDTO doSeckillReqDTO) {

        seckillService.doSeckil(ToDoSeckillEntity.INSTANCE.convert(doSeckillReqDTO));

    }
}
