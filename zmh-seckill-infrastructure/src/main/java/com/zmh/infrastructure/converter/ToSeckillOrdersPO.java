package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.SeckillOrdersEntity;
import com.zmh.infrastructure.po.SeckillOrdersPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToSeckillOrdersPO
 * @author: zhou ming hao
 * @date: 2024年08月01日 22:09
 */
@Mapper
public interface ToSeckillOrdersPO extends PlusMapper<SeckillOrdersPO, SeckillOrdersEntity> {
    ToSeckillOrdersPO INSTANCE = Mappers.getMapper(ToSeckillOrdersPO.class);

}
