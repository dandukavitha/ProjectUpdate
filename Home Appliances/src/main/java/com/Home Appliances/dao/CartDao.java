package com.HomeAppliances.dao;

import com.HomeAppliances.model.Cart;

import java.io.IOException;


public interface CartDao {

    Cart getCartById (int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
