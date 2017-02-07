package com.HomeAppliances.service;

import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.CartItem;


public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByItemId (int itemId);
}
