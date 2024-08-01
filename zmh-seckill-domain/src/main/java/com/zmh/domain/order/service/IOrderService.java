package com.zmh.domain.order.service;

import com.zmh.domain.order.model.entity.PlaceOrderEntity;

/**
 * @Description: IOrderService
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:50
 */

public interface IOrderService {

    void placeOrder(PlaceOrderEntity placeOrder);

}
