package com.zmh.infrastructure.dao;

import com.zmh.infrastructure.po.SeckillOrdersPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description: SeckillOrdersDao 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 16:09
 */
@Mapper
public interface SeckillOrdersDao {

    List<SeckillOrdersPO> getSeckillOrder(RowBounds rowBounds);
}
