package com.HomeAppliances.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HomeAppliances.model.UsersDetail;
import com.HomeAppliances.model.Cart;
import com.HomeAppliances.model.UserRole;
@Repository
public class UsersDetailDaoImpl implements UsersDetailDao{
	@Autowired
	private SessionFactory factory;
    @Transactional
	public void signUp(UsersDetail usersDetail) {
		System.out.println(" I am in CustomerDaoImpl");
		Session session=factory.getCurrentSession();
		  Transaction tx=session.beginTransaction();
		  usersDetail.getShippingAddress().setUsersDetail(usersDetail);
		  usersDetail.setEnabled(true);
		session.saveOrUpdate(usersDetail);
		session.saveOrUpdate(usersDetail.getShippingAddress());
		UserRole userRole=new UserRole();
		userRole.setUser_role_id(usersDetail.getUserId());
		userRole.setAuthority("ROLE_USER");
		session.saveOrUpdate(userRole);
		Cart newCart=new Cart();
		newCart.setUsersDetail(usersDetail);
		usersDetail.setCart(newCart);
		session.saveOrUpdate(usersDetail);
		session.saveOrUpdate(newCart);
		tx.commit();
	}
    @Transactional
	public boolean checkForEmail(UsersDetail customer) {
		System.out.println("I am in checkForMail");
		String email=customer.getEmail();
		Session session=factory.getCurrentSession();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("select password from UsersDetail where email='"+email+"'");
		query.setMaxResults(1);
		String result=(String)query.uniqueResult();
		if(result!=null)
		{
			return true;
		}
		else
		return false;
	}
    @Transactional
	public List<UsersDetail> viewAllCustomers() {
		 Session session=factory.getCurrentSession();
		 Transaction tx=session.beginTransaction();
		 List<UsersDetail> list =session.createCriteria(UsersDetail.class).list();
		 return list;
	}
	public boolean deleteCustomer(int id) {
		System.out.println("Id in deleteCustomer(int id):"+id);
	    Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    Query query=session.createQuery("delete from UsersDetail where userId=:status");
	    query.setInteger("status",id);
	    int rowsDeleted=query.executeUpdate();
	    tx.commit();
	    System.out.println("Rows deleted:"+rowsDeleted);
	    if(rowsDeleted!=1)
	    	return true;
	    else
	    	return false;
	}
	  @Transactional(readOnly = true)
	public UsersDetail getUserByUsername(String username) {
		Session session = factory.openSession();
		System.out.println("i am in get username:"+session);
		Transaction tx=session.beginTransaction();
        Query query = session.createQuery("from UsersDetail where firstName = ?");
        query.setString(0, username);
        tx.commit();
        return (UsersDetail) query.uniqueResult();
	}

}
