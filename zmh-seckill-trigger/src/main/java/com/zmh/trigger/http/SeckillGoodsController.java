package com.zmh.trigger.http;

import com.zmh.app.result.Result;
import com.zmh.trigger.http.cmd.ISeckillGoodsCommand;
import com.zmh.trigger.http.dto.req.QuerySeckillGoodsReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsDetailsRespDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: SeckillController
 * @author: zhou ming hao
 * @date: 2024年07月28日 16:25
 */
@RestController()
@RequestMapping("/seckillGoods")
@RequiredArgsConstructor
@Api(tags = "秒杀商品信息api")
public class SeckillGoodsController {

    private final ISeckillGoodsCommand seckillGoodsCommand;


    @ApiOperation("查询秒杀商品列表")
    @PostMapping(path = "/getSeckill")
    public Result<List<QuerySeckillGoodsRespDTO>> querySeckillGoodsList(@RequestBody QuerySeckillGoodsReqDTO querySeckillGoodsReq) {

        return Result.success(seckillGoodsCommand.querySeckillGoodsList(querySeckillGoodsReq));
    }


    @ApiOperation("获取秒杀详情")
    @GetMapping(path = "/{seckillGoodsId}")
    public Result<QuerySeckillGoodsDetailsRespDTO> querySeckillGoodsDetails(@PathVariable("seckillGoodsId") Long seckillGoodsId) {
        return Result.success();
    }


}
