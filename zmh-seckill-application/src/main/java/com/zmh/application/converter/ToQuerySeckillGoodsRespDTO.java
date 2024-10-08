package com.zmh.application.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.order.model.aggregates.SeckillGoodsAggregates;
import com.zmh.trigger.http.dto.resp.QuerySeckillGoodsRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToQuerySeckillGoodsRespDTOMapper
 * @author: zhou ming hao
 * @date: 2024年07月31日 1:07
 */
@Mapper
public interface ToQuerySeckillGoodsRespDTO extends PlusMapper<QuerySeckillGoodsRespDTO, SeckillGoodsAggregates> {
    ToQuerySeckillOrderRespDTO INSTANCE = Mappers.getMapper(ToQuerySeckillOrderRespDTO.class);
}
