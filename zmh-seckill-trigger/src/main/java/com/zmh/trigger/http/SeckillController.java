package com.zmh.trigger.http;

import com.zmh.app.result.Result;
import com.zmh.application.cmd.seckill.ISeckillCommand;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: SeckillController
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:08
 */
@RestController()
@RequestMapping("/seckill")
@RequiredArgsConstructor
public class SeckillController {

    private final ISeckillCommand seckillCommand;

    /**
     * 秒杀商品
     */
    @GetMapping(path = "/doSeckill/{seckillGoodsId}")
    public Result<Void> doSeckill(@RequestBody DoSeckillReqDTO doSeckillReqDTO, @PathVariable("seckillGoodsId") Long seckillGoodsId){
        return Result.success();
    }
}
