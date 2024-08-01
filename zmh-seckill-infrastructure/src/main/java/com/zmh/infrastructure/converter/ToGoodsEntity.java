package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.entity.GoodsEntity;
import com.zmh.infrastructure.po.GoodsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToGoodsEntity
 * @author: zhou ming hao
 * @date: 2024年07月31日 0:45
 */
@Mapper
public interface ToGoodsEntity extends PlusMapper<GoodsEntity, GoodsPO> {

    ToGoodsEntity INSTANCE = Mappers.getMapper(ToGoodsEntity.class);

}
