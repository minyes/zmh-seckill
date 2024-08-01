package com.zmh.infrastructure.dao;

import com.zmh.infrastructure.po.IdempotencyKeysPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: IdempotencyKeysDao
 * @author: zhou ming hao
 * @date: 2024年08月01日 17:37
 */

@Mapper
public interface IdempotencyKeysDao {

    int insertIdempotencyKeys(IdempotencyKeysPO idempotencyKeysPO);
}
