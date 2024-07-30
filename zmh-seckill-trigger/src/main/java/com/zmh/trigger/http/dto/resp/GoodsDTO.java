package com.zmh.trigger.http.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: GoodsDTO
 * @author: zhou ming hao
 * @date: 2024年07月31日 1:38
 */
@Data
@ApiModel(value = "商品信息")
public class GoodsDTO {

    @ApiModelProperty(value = "产品id")
    private Long goodsId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "库存数量")
    private Long stock;
}
