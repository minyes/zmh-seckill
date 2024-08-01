package com.zmh.trigger.http.cmd;

import com.zmh.trigger.http.dto.req.QuerySeckillGoodsReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;

import java.util.List;

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
    List<QuerySeckillGoodsRespDTO> querySeckillGoodsList(QuerySeckillGoodsReqDTO querySeckillGoodsReqDTO);

    /**
     * 查询秒杀商品详情信息
     * @param seckillGoodsId
     * @return
     */
    QuerySeckillGoodsRespDTO querySeckillGoodsDetails(Long seckillGoodsId);
}
