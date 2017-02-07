package com.HomeAppliances.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HomeAppliances.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SessionFactory factory;
	@Transactional
	public boolean addProduct(Item product) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
	     session.saveOrUpdate(product);
	     tx.commit();
	     System.out.println("After commit");
	     return true;
	}
	@Transactional
	public List<Item> viewProducts() {	
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Item> list=session.createCriteria(Item.class).list();
		tx.commit();
		return list;
	}
	@Transactional
	public boolean deleteProduct(int id) {
		System.out.println("Id in deleteProduct(int id):"+id);
	    Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    Query query=session.createQuery("delete from Item where id=:status");
	    query.setInteger("status",id);
	    int rowsDeleted=query.executeUpdate();
	    tx.commit();
	    System.out.println("Rows deleted:"+rowsDeleted);
	    if(rowsDeleted!=1)
	    	return true;
	    else
	    	return false;
		
	}
public Item getProduct(int productid) {
		
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction(); 
				 return (Item)s.get(Item.class, productid); 
	}

}
