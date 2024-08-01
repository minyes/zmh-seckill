package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.SeckillOrdersEntity;
import com.zmh.infrastructure.po.SeckillOrdersPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToSeckillOrdersEntity
 * @author: zhou ming hao
 * @date: 2024年08月01日 21:14
 */
@Mapper
public interface ToSeckillOrdersEntity extends PlusMapper<SeckillOrdersEntity, SeckillOrdersPO> {
    ToSeckillOrdersEntity INSTANCE = Mappers.getMapper(ToSeckillOrdersEntity.class);


}
