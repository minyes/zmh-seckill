package com.zmh.trigger.http;

import com.zmh.app.result.Result;
import com.zmh.trigger.http.cmd.ISeckillGoodsCommand;
import com.zmh.trigger.http.dto.req.QuerySeckillGoodsReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsDetailsRespDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: SeckillController
 * @author: zhou ming hao
 * @date: 2024年07月28日 16:25
 */
@RestController()
@RequestMapping("/seckillGoods")
@RequiredArgsConstructor
public class SeckillGoodsController {

    private ISeckillGoodsCommand seckillGoodsCommand;

    /**
     * 查询商品列表
     */
    @PostMapping(path = "/getSeckill")
    public Result<QuerySeckillGoodsRespDTO> querySeckillGoodsList(@RequestBody QuerySeckillGoodsReqDTO querySeckillGoodsReq){

        return Result.success();
    }

    /**
     * 获取秒杀详情
     * @param seckillGoodsId
     * @return
     */
    @GetMapping(path = "/{seckillGoodsId}")
    public Result<QuerySeckillGoodsDetailsRespDTO> querySeckillGoodsDetails(@PathVariable("seckillGoodsId") Long seckillGoodsId){
        return Result.success();
    }


}
