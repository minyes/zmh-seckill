package com.zmh.application.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.aggregates.SeckillOrdersAggregate;
import com.zmh.trigger.http.dto.resp.QuerySeckillOrderRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToQuerySeckillOrderRespDTO
 * @author: zhou ming hao
 * @date: 2024年08月01日 22:54
 */
@Mapper
public interface ToQuerySeckillOrderRespDTO extends PlusMapper<QuerySeckillOrderRespDTO, SeckillOrdersAggregate> {
    ToQuerySeckillGoodsRespDTO INSTANCE = Mappers.getMapper(ToQuerySeckillGoodsRespDTO.class);

}
