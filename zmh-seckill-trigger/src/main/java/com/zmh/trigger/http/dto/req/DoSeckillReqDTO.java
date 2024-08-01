package com.zmh.trigger.http.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: DoSeckillReqDTO
 * @author: zhou ming hao
 * @date: 2024年07月29日 0:14
 */
@Data
@ApiModel(value = "秒杀请求信息")
public class DoSeckillReqDTO {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "秒杀商品id")
    private Long seckillGoodsId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

}
