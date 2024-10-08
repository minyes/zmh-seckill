package com.zmh.trigger.http;

import com.zmh.app.result.Result;
import com.zmh.trigger.http.cmd.ISeckillOrderCommand;
import com.zmh.trigger.http.dto.req.PaySeckillOrderReqDTO;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: SeckillOrderController
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:26
 */
@RestController()
@RequestMapping("/seckillOrder")
@RequiredArgsConstructor
public class SeckillOrderController {

    private final ISeckillOrderCommand seckillOrderCommand;
    /**
     * 秒杀订单查询
     */
    @GetMapping(path = "/{orderId}")
    public Result<QuerySeckillOrderRespDTO> getSeckillOrder(@PathVariable("orderId") Long orderId){

        return Result.success(seckillOrderCommand.getSeckillOrder(orderId));
    }
    @GetMapping(path = "/pay/{seckillOrderId}")
    public Result<Void> paySeckillOrder(@RequestBody PaySeckillOrderReqDTO paySeckillOrderReqDTO, @PathVariable("seckillOrderId") Long seckillOrderId){
        seckillOrderCommand.paySeckillOrder(paySeckillOrderReqDTO,seckillOrderId);
        return Result.success();
    }
}
