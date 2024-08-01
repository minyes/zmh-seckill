package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: QuerySeckillGoodsRespDTO
 * @author: zhou ming hao
 * @date: 2024年07月28日 21:46
 */
@Data
@ApiModel(value = "查询秒杀商品列表响应信息")
public class QuerySeckillGoodsRespDTO {

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "商品信息")
    private GoodsDTO goods;

    @ApiModelProperty(value = "秒杀信息")
    private SeckillGoodsDTO seckillGoods;
}
