package com.zmh.infrastructure.repository.mysql;

import com.zmh.domain.idempotency.model.entity.IdempotencyKeysEntity;
import com.zmh.domain.idempotency.repository.IIdempotencyRepository;
import com.zmh.infrastructure.converter.ToIdempotencyKeysPO;
import com.zmh.infrastructure.dao.IdempotencyKeysDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Description: IdempotencyRepository
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:53
 */
@Repository
@RequiredArgsConstructor
public class IdempotencyRepository implements IIdempotencyRepository {


    private final IdempotencyKeysDao idempotencyKeysDao;

    @Override
    public void createIdempotencyKeys(IdempotencyKeysEntity idempotencyKeysEntity) {
        idempotencyKeysDao.insertIdempotencyKeys(ToIdempotencyKeysPO.INSTANCE.convert(idempotencyKeysEntity));
    }
}
