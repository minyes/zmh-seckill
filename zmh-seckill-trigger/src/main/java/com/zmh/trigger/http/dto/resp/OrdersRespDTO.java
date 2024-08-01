package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: OrdersRespDTO 订单表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:56
 */
@Data
@ApiModel(value = "订单信息")
public class OrdersRespDTO {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

}
