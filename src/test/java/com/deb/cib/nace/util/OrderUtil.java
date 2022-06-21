package com.deb.cib.nace.util;

import com.deb.cib.nace.domain.Order;

public class OrderUtil {
    public static Order getSampleOrder(Integer orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setLevel(1);
        order.setCode("A");
        order.setDescription("Test Order");
        return order;
    }
}
