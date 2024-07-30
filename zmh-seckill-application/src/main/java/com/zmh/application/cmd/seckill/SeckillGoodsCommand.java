package com.zmh.application.cmd.seckill;

import com.zmh.trigger.http.cmd.ISeckillGoodsCommand;
import com.zmh.application.converter.ToQuerySeckillGoodsRespDTOMapper;
import com.zmh.domain.goods.service.ISeckillGoodsService;
import com.zmh.trigger.http.dto.req.QuerySeckillGoodsReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsDetailsRespDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: GoodsCommand 秒杀商品命令
 * @author: zhou ming hao
 * @date: 2024年07月28日 21:42
 */
@Component
@RequiredArgsConstructor
public class SeckillGoodsCommand implements ISeckillGoodsCommand {

    private final ISeckillGoodsService seckillGoodsService;

    @Override
    public List<QuerySeckillGoodsRespDTO> querySeckillGoodsList(QuerySeckillGoodsReqDTO querySeckillGoodsReqDTO) {
        return ToQuerySeckillGoodsRespDTOMapper.INSTANCE.toList(
                seckillGoodsService.getSeckillGoodsList(querySeckillGoodsReqDTO.getPageNum(), querySeckillGoodsReqDTO.getLimit()));
    }

    @Override
    public QuerySeckillGoodsDetailsRespDTO querySeckillGoodsDetails(Long seckillGoodsId) {

        return null;
    }
}
