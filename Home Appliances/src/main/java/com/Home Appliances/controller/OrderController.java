package com.HomeAppliances.controller;

import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.model.UserOrder;
import com.HomeAppliances.service.CartService;
import com.HomeAppliances.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {
    	UserOrder userOrder = new UserOrder();
        Cart cart=cartService.getCartById(cartId);
        System.out.println("cart:"+cart.getCartId());
        userOrder.setCart(cart);

        UsersDetail usersDetail = cart.getUsersDetail();
        userOrder.setUsersDetail(usersDetail);
        
        userOrder.setShippingAddress(usersDetail.getShippingAddress());

        orderService.addOrder(userOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
