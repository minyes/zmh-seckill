package com.zmh.infrastructure.converter;

import com.zmh.app.common.PlusMapper;
import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;
import com.zmh.infrastructure.po.IdempotencyKeysPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: ToIdempotencyKeysPO
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:01
 */
@Mapper
public interface ToIdempotencyKeysPO extends PlusMapper<IdempotencyKeysPO, IdempotencyKeysEntity> {
    ToIdempotencyKeysPO INSTANCE = Mappers.getMapper(ToIdempotencyKeysPO.class);

}
