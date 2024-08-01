package com.zmh.trigger.mq.cmd;

/**
 * @Description: IOrdersCommand
 * @author: zhou ming hao
 * @date: 2024年08月01日 18:34
 */

public interface IOrdersCommand {

    /**
     * 下单
     * @param message
     */
    void placeOrder(String message);


}
