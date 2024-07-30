package com.zmh.infrastructure.dao;

import com.zmh.infrastructure.po.OrdersPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: OrdersDao 秒杀商品表
 * @author: zhou ming hao
 * @date: 2024年07月27日 16:07
 */
@Mapper
public interface OrdersDao {

    List<OrdersPO> getOrdersList(List<Long> ordersIds);
}
