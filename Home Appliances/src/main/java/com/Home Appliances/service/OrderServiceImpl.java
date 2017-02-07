package com.HomeAppliances.service;

import com.HomeAppliances.dao.OrderDao;
import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.CartItem;
import com.HomeAppliances.model.UserOrder;
import com.HomeAppliances.service.CartService;
import com.HomeAppliances.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    public void addOrder(UserOrder userOrder) {
    	orderDao.addOrder(userOrder);
    }

    public double getOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }
}
