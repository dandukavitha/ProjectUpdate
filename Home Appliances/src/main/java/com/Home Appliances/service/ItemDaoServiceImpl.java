package com.HomeAppliances.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomeAppliances.dao.ItemDao;
import com.HomeAppliances.model.Item;

@Service
public class ItemDaoServiceImpl implements ItemDaoService {
	@Autowired
private	ItemDao dao;
	public boolean addProduct(Item product) {
		
		return dao.addProduct(product);
	}
	public List<Item> viewProducts() {
		return  dao.viewProducts();
	}
	public boolean deleteProduct(int id) {
		return dao.deleteProduct(id);
	}
	public Item getProduct(int productid) {
		
		return dao.getProduct(productid);
	}

}
