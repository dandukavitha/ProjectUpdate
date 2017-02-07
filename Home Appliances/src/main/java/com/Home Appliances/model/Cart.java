package com.HomeAppliances.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;



@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = 13L;

    @Id
    @GeneratedValue
    private int cartId;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private UsersDetail usersDetail;
	private double grandTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public UsersDetail getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(UsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}
}
