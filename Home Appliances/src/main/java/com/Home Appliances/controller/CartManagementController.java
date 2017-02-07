package com.HomeAppliances.controller;

import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.CartItem;
import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.model.Item;
import com.HomeAppliances.service.CartItemService;
import com.HomeAppliances.service.CartService;
import com.HomeAppliances.service.ItemDaoService;
import com.HomeAppliances.service.UsersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;	

import java.util.List;

@Controller
@RequestMapping("/usercart/cart")
public class CartManagementController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UsersDetailService usersDetailService;

    @Autowired
    private ItemDaoService itemService;
    @RequestMapping("/test")
    public  void testData()
    {
    	System.out.println("This is test");
    }
    @RequestMapping("/refreshCart/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable(value = "cartId") int cartId) {
    	System.out.println("testing for refresh");
         Cart cart=cartService.getCartById(cartId);
         System.out.println("cart object:"+cart);
         return cart;
    }

    @RequestMapping(value = "/addItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value ="itemId") int itemId, @AuthenticationPrincipal User activeUser) {
 System.out.println("add item called");
    	System.out.println("itemid:"+itemId);
    	System.out.println("active user:"+activeUser.getUsername());
    	UsersDetail usersDetail = usersDetailService.getUserByUsername(activeUser.getUsername());
    	System.out.println("after getuserbyusername");
        Cart cart = usersDetail.getCart();
        System.out.println("cart id:"+cart.getCartId());
        Item item = itemService.getProduct(itemId);
        List<CartItem> cartItems = cart.getCartItems();
        if(!cartItems.isEmpty())
        {
        System.out.println("cart Items:"+cartItems);
          System.out.println("product id:"+item.getProduct_id());
          System.out.println("get item:"+cartItems.get(0).getItem().getProduct_id());
        for (int i=0; i<cartItems.size(); i++) {
            if(item.getProduct_id()==cartItems.get(i).getItem().getProduct_id()){
            	System.out.println("Inside for loop");
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(item.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }
        }
        System.out.println("After line 75");
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(item.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }
    /*
     * removeItem method is used to remove a item from user cart.
     */
    @RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable(value = "itemId") int itemId) {
    	System.out.println("product id:"+itemId);
        CartItem cartItem = cartItemService.getCartItemByItemId(itemId);
        cartItemService.removeCartItem(cartItem);

    }
    /*
     * clearCartItems method is used to remove all items from user cart.
     */
    @RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCartItems(@PathVariable(value = "cartId") int cartId) {
    	
        Cart cart = cartService.getCartById(cartId);
        System.out.println("mycart:"+cart.getCartId());
       // System.out.println("cart value:"+cartId);
        cartItemService.removeAllCartItems(cart);
        System.out.println(" after remove cart clear");
    }
    /*
     * ExceptionHandler for client errors.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}
    /*
     * ExceptionHandler for server errors.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
}
