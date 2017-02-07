package com.HomeAppliances.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomeAppliances.dao.UsersDetailDao;
import com.HomeAppliances.model.UsersDetail;
@Service
public class UsersDetailServiceImpl implements UsersDetailService{
	@Autowired
private UsersDetailDao dao;
	public void signUp(UsersDetail customer) {
		System.out.println(" I am in CustomerDaoServiceImpl");
		dao.signUp(customer);
	}
	public boolean checkForEmail(UsersDetail customer) {
		return dao.checkForEmail(customer);
	}

	public List<UsersDetail> viewAllCustomers() {
		return dao.viewAllCustomers();
	}

	public boolean deleteCustomer(int id) {
		return dao.deleteCustomer(id);
	}
	public UsersDetail getUserByUsername (String username) {
        return dao.getUserByUsername(username);
    }

}
