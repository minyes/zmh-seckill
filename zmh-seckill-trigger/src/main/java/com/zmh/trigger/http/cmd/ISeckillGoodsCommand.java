package com.zmh.trigger.http.cmd;

import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsDetailsRespDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;

/**
 * @Description: GoodsCmd
 * @author: zhou ming hao
 * @date: 2024年07月28日 21:29
 */

public interface ISeckillGoodsCommand {

    /**
     * 获取秒杀商品列表
     * @return
     */
    QuerySeckillGoodsRespDTO querySeckillGoodsList();

    /**
     * 查询秒杀商品详情信息
     * @param seckillGoodsId
     * @return
     */
    QuerySeckillGoodsDetailsRespDTO querySeckillGoodsDetails(Long seckillGoodsId);
}
