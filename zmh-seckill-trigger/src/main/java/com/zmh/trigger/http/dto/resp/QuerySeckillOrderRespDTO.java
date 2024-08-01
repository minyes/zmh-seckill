package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: QuerySeckillOrderRespDTO
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:40
 */
@Data
@ApiModel(value = "查询秒杀订单信息")
public class QuerySeckillOrderRespDTO {

    @ApiModelProperty(value = "订单信息")
    private OrdersRespDTO orders;

    @ApiModelProperty(value = "秒杀订单信息")
    private SeckillOrdersRespDTO seckillOrders;
}
