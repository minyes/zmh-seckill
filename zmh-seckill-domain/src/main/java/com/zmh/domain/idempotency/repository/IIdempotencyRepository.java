package com.zmh.domain.idempotency.repository;

import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;

/**
 * @Description: IdempotencyRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:51
 */

public interface IIdempotencyRepository {

    void createIdempotencyKeys(IdempotencyKeysEntity idempotencyKeysEntity);

}
