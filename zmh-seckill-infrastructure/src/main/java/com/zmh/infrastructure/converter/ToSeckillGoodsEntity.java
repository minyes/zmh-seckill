package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.SeckillGoodsEntity;
import com.zmh.infrastructure.po.SeckillGoodsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToSeckillGoodsEntity
 * @author: zhou ming hao
 * @date: 2024年07月31日 1:16
 */
@Mapper
public interface ToSeckillGoodsEntity extends PlusMapper<SeckillGoodsEntity, SeckillGoodsPO> {
    ToSeckillGoodsEntity INSTANCE = Mappers.getMapper(ToSeckillGoodsEntity.class);


}
