package com.zmh.infrastructure.repository.mysql;

import com.zmh.domain.order.model.aggregates.CreateSeckillOrdersAggregate;
import com.zmh.domain.order.model.entity.SeckillGoodsEntity;
import com.zmh.domain.order.model.entity.SeckillOrdersEntity;
import com.zmh.domain.order.repository.ISeckillOrderRepository;
import com.zmh.infrastructure.converter.ToOrdersPO;
import com.zmh.infrastructure.converter.ToSeckillGoodsEntity;
import com.zmh.infrastructure.converter.ToSeckillOrdersEntity;
import com.zmh.infrastructure.converter.ToSeckillOrdersPO;
import com.zmh.infrastructure.dao.OrdersDao;
import com.zmh.infrastructure.dao.SeckillGoodsDao;
import com.zmh.infrastructure.dao.SeckillOrdersDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: SeckillOrderRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 21:09
 */
@Repository
@RequiredArgsConstructor
public class SeckillOrderRepository implements ISeckillOrderRepository {

    private final OrdersDao ordersDao;

    private final SeckillOrdersDao seckillOrdersDao;

    private final SeckillGoodsDao seckillGoodsDao;

    /**
     * 查询秒杀订单
     * @param userId
     * @param orderId
     * @return
     */
    @Override
    public SeckillOrdersEntity querySeckillOrder(Long userId, Long orderId) {
        return ToSeckillOrdersEntity.INSTANCE.convert(seckillOrdersDao.querySeckillOrderByUserIdAndGoodsid(userId, orderId));
    }

    /**
     * 创建秒杀订单
     * @param createSeckillOrdersAggregate
     */
    @Transactional
    @Override
    public void createSeckillOrder(CreateSeckillOrdersAggregate createSeckillOrdersAggregate) {

        //插入订单
        ordersDao.insertOders(ToOrdersPO.INSTANCE.convert(createSeckillOrdersAggregate.getOrders()));

        //插入秒杀订单
        seckillOrdersDao.insertSeckillOrders(ToSeckillOrdersPO.INSTANCE.convert(createSeckillOrdersAggregate.getSeckillOrders()));
    }

    /**
     * 查询秒杀商品信息
     * @param seckillGoodsId
     * @return
     */
    @Override
    public SeckillGoodsEntity querySeckillGoods(Long seckillGoodsId) {

        return ToSeckillGoodsEntity.INSTANCE.convert(seckillGoodsDao.querySeckillGoods(seckillGoodsId));
    }

}
