package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.OrdersEntity;
import com.zmh.infrastructure.po.OrdersPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToOrdersEntity
 * @author: zhou ming hao
 * @date: 2024年08月01日 22:45
 */
@Mapper
public interface ToOrdersEntity extends PlusMapper<OrdersEntity, OrdersPO> {
    ToOrdersEntity INSTANCE = Mappers.getMapper(ToOrdersEntity.class);

}
