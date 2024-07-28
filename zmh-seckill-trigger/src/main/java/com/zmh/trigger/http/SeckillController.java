package com.zmh.trigger.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: SeckillController
 * @author: zhou ming hao
 * @date: 2024年07月28日 16:25
 */
@RestController()
public class SeckillController {
    /**
     * 查询商品列表
     */
    @PostMapping(path = "/getSecKill")
    public void querySeckillGoodsList(){

    }
}
