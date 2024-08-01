package com.zmh.domain.idempotency.service;

import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;
import com.zmh.domain.idempotency.repository.IIdempotencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description: IdempotencyService 幂等类
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:47
 */
@Service
@RequiredArgsConstructor
public class IdempotencyService implements IIdempotencyService{

    private final IIdempotencyRepository idempotencyRepository;

    /**
     * 幂等  幂等性键 唯一
     * @param idempotencyKeysEntity
     */
    @Override
    public void idempotency(IdempotencyKeysEntity idempotencyKeysEntity) {
        idempotencyRepository.createIdempotencyKeys(idempotencyKeysEntity);
    }
}
