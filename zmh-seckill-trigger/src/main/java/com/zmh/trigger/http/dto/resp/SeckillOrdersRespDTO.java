package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: SeckillOrdersRespDTO 秒杀订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:39
 */
@Data
@ApiModel(value = "秒杀订单信息")
public class SeckillOrdersRespDTO {

    @ApiModelProperty(value = "秒杀订单id")
    private Long seckillOrderId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "秒杀商品ID")
    private Long seckillGoodsId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

}
