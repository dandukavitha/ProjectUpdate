package com.HomeAppliances.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class UsersDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@NotEmpty(message="firstName Should not be empty")
	private String firstName;
	@NotEmpty(message="firstName Should not be empty")
	private String lastName;
	@NotEmpty(message="email Should not be empty")
	private String email;
	@NotEmpty(message="password Should not be empty")
	private String password;
	private String month;
	private String date;
	private String year;
	private String gender;
	private boolean enabled;
	@OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAdd shippingAddress;
    
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
    
	public ShippingAdd getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAdd shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
