package com.HomeAppliances.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity
public class Item implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;
	@NotEmpty(message="should not be empty")
	@Size(min=3, message="must have atleast three characters")
	private String product_name;
	private String product_category;
	private String typeOfProduct;
	private long price;
	@Size(min=20, message="must have atleast 20 characters")
	private String description;
	private String brand;
	
    @OneToOne
	
    private CartItem cartItem;

	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Transient
	 MultipartFile file;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getTypeOfProduct() {
		return typeOfProduct;
	}
	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
