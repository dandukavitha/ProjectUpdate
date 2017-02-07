package com.HomeAppliances.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Role")
public class UserRole {
	@Id
	private int user_role_id;
	private String authority;
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	

}
