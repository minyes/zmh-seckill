package com.zmh.domain.order.model.valobj;

/**
 * @Description: OrderStatus
 * @author: zhou ming hao
 * @date: 2024年08月01日 21:30
 */

public enum OrderStatus {
    PENDING("pending","待处理"),
    COMPLETED("completed","支付完成"),
    CANCELED("canceled","取消")
    ;

    OrderStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public OrderStatus getOrderStatus(String code){

        OrderStatus[] orderStatuses = values();
        for (OrderStatus orderStatus :orderStatuses){
            if(orderStatus.getCode().equals(code)){
                return orderStatus;
            }
        }
        return null;
    }
}
