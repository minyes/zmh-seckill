package com.zmh.infrastructure.dao;

import com.zmh.infrastructure.po.GoodsPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: ProductsDao 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 16:08
 */
@Mapper
public interface GoodsDao {

    List<GoodsPO> queryGoodsList(List<Long> goodsIdList);

    GoodsPO queryGoodsByGoodsId(Long goodsId);

}
