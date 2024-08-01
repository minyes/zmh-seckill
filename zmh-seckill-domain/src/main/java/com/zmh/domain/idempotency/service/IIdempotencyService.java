package com.zmh.domain.idempotency.service;

import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;

/**
 * @Description: IIdempotency
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:33
 */

public interface IIdempotencyService {

    void idempotency(IdempotencyKeysEntity idempotencyKeysEntity);
}
