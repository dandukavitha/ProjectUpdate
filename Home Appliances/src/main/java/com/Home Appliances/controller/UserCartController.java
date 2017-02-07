package com.HomeAppliances.controller;

import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.service.UsersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * This controller is called when user clicks on cart menu or button
 */
@Controller
@RequestMapping("/user/cart")
public class UserCartController {

    @Autowired
    private UsersDetailService usersDetailService;
    
    /*
     * Initially getCart method is called to get user card items from database
     */
    @RequestMapping
    public String getCartItems(@AuthenticationPrincipal User activeUser){
    	UsersDetail usersDetail = usersDetailService.getUserByUsername (activeUser.getUsername());
        int cartId = usersDetail.getCart().getCartId();

        return "redirect:/user/cart/"+cartId;
    }
    /*
     * getCartRedirect method is called from getCart method to set retrieved cart from the database.
     */
    @RequestMapping("/{cartId}")
    public String getNewUrl(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }

}
