package com.HomeAppliances.service;

import com.HomeAppliances.model.Cart;


public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
