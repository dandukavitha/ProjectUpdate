package com.HomeAppliances.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserOrder implements Serializable{

    private static final long serialVersionUID = 16L;

    @Id
    @GeneratedValue
    private int userOrderId;
	@OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "userId")
    private UsersDetail usersDetail;

	

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAdd shippingAddress;

    public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    public ShippingAdd getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAdd shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public UsersDetail getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(UsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}
}
