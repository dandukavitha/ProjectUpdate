package com.HomeAppliances.dao;

import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.CartItem;


public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByItemId (int itemId);

}
