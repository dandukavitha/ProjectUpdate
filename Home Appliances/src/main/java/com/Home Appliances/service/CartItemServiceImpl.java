package com.HomeAppliances.service;

import com.HomeAppliances.dao.CartItemDao;
import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.CartItem;
import com.HomeAppliances.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
    	
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
    	System.out.println("In Remove Cart item service");
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByItemId (int itemId) {
        return cartItemDao.getCartItemByItemId(itemId);
    }
}
