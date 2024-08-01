package com.zmh.infrastructure.dao;

import com.zmh.infrastructure.po.SeckillGoodsPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description: SeckillProductsDao 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 16:14
 */
@Mapper
public interface SeckillGoodsDao {

    List<SeckillGoodsPO> querySeckillGoodsList(RowBounds rowBounds);

    SeckillGoodsPO uerySeckillGoodsBySeckillGoodsId(Long seckillGoodsId);

    List<SeckillGoodsPO> querySeckillGoodsAll();

    SeckillGoodsPO querySeckillGoods(Long seckillGoodsId);

}
