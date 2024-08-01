package com.zmh.trigger.http;

import com.zmh.app.result.Result;
import com.zmh.trigger.http.cmd.ISeckillCommand;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "商品秒杀api")
public class SeckillController {

    private final ISeckillCommand seckillCommand;

    @PostMapping(path = "/doSeckill")
    @ApiOperation("秒杀商品")
    public Result<Void> doSeckill(@RequestBody DoSeckillReqDTO doSeckillReqDTO){
        seckillCommand.doSeckill(doSeckillReqDTO);
        return Result.success();
    }
}
