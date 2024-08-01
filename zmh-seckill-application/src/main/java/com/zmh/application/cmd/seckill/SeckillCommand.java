package com.zmh.application.cmd.seckill;

import com.zmh.application.converter.ToDoSeckillEntity;
import com.zmh.domain.goods.service.ISeckillService;
import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;
import com.zmh.domain.idempotency.service.IIdempotencyService;
import com.zmh.trigger.http.cmd.ISeckillCommand;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: SeckillCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:35
 */
@Component
@RequiredArgsConstructor
public class SeckillCommand implements ISeckillCommand {

    private final ISeckillService seckillService;

    private final IIdempotencyService idempotencyService;

    @Transactional
    @Override
    public void doSeckill(DoSeckillReqDTO doSeckillReqDTO) {

        // 落幂等表 强控  userId+goodsId
        idempotencyService.idempotency(IdempotencyKeysEntity.builder().transCode("seckill")
                .idempotencyKey(doSeckillReqDTO.getUserId() + ":" + doSeckillReqDTO.getSeckillGoodsId()).build());
        //下单
        seckillService.doSeckil(ToDoSeckillEntity.INSTANCE.convert(doSeckillReqDTO));

    }
}
