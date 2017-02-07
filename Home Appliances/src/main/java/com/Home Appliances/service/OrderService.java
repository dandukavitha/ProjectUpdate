package com.HomeAppliances.service;

import com.HomeAppliances.model.UserOrder;


public interface OrderService {

    void addOrder(UserOrder order);

    double getOrderGrandTotal(int cartId);
}
