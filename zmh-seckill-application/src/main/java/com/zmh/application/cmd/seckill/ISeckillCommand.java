package com.zmh.application.cmd.seckill;

import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;

/**
 * @Description: ISeckillCommand
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:34
 */

public interface ISeckillCommand {
    /**
     * 秒杀商品 抢库存 下单
     * @param doSeckillReqDTO
     * @param seckillGoodsId
     */
    void doSeckill(DoSeckillReqDTO doSeckillReqDTO, Long seckillGoodsId);
}
