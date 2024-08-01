package com.zmh.application.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.goods.model.entity.DoSeckillEntity;
import com.zmh.trigger.http.dto.req.DoSeckillReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToSeckillEntity
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:22
 */
@Mapper
public interface ToDoSeckillEntity extends PlusMapper<DoSeckillEntity, DoSeckillReqDTO> {
    ToDoSeckillEntity INSTANCE = Mappers.getMapper(ToDoSeckillEntity.class);

}
