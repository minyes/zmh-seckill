package com.zmh.trigger.http.dto.req;

import lombok.Data;

/**
 * @Description: DoSeckillReqDTO
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:14
 */
@Data
public class DoSeckillReqDTO {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 秒杀商品id
     */
    private Long seckillGoodsId;

    /**
     *
     */
    private Long goodsId;

}
