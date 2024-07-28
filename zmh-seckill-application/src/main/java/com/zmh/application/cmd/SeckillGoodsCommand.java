package com.zmh.application.cmd;

import com.zmh.trigger.http.cmd.ISeckillGoodsCommand;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsDetailsRespDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;
import org.springframework.stereotype.Component;

/**
 * @Description: GoodsCommand 商品命令
 * @author: zhou ming hao
 * @date: 2024年07月28日 21:42
 */
@Component
public class SeckillGoodsCommand implements ISeckillGoodsCommand {

    @Override
    public QuerySeckillGoodsRespDTO querySeckillGoodsList() {
        // 判断当前页是否为前三页 是 从redis拿  不是 从库里拿并缓存到redis中

        // 当前页不是前三页 从库中取

        return null;
    }

    @Override
    public QuerySeckillGoodsDetailsRespDTO querySeckillGoodsDetails(Long seckillGoodsId) {
        return null;
    }
}
