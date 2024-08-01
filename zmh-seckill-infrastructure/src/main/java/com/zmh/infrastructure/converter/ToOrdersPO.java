package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.OrdersEntity;
import com.zmh.infrastructure.po.OrdersPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToOrdersPO
 * @author: zhou ming hao
 * @date: 2024年08月01日 22:07
 */
@Mapper
public interface ToOrdersPO extends PlusMapper<OrdersPO, OrdersEntity> {
    ToOrdersPO INSTANCE = Mappers.getMapper(ToOrdersPO.class);

}
