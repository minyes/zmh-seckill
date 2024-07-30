package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description: SeckillGoodsDTO
 * @author: zhou ming hao
 * @date: 2024年07月31日 1:37
 */
@Data
@ApiModel(value = "商品秒杀信息")
public class SeckillGoodsDTO {

    @ApiModelProperty(value = "秒杀商品ID")
    private Long seckillGoodsId;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "秒杀价格")
    private String seckillPrice;

    @ApiModelProperty(value = "秒杀开始时间")
    private LocalDate startTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private LocalDate endTime;

    @ApiModelProperty(value = "秒杀库存数量")
    private Long stock;
}
