package com.zmh.domain.goods.model.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: ProductsPO 商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:50
 */
@Data
public class GoodsEntity {

    /**
     * 产品id
     */
    private Long goodsId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Long stock;
}
