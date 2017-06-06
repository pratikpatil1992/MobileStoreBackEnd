package com.niit.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.CartDAO;
import com.niit.MobileStoreBackEnd.domain.Cart;


@Repository("cartDAO")     //to create singleton instance
@Transactional

public class CartDAOImpl implements CartDAO
{
	@Override
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	
	@Autowired private SessionFactory sessionFactory;	
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
		
	public List<Cart> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
	}
		
	public boolean save(Cart cart)
	{
		try
		{
			getCurrentSession().save(cart);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) 
	{
		try
		{
			getCurrentSession().delete(getCartById(id));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cart getCartById(int id) 
	{
		return (Cart) getCurrentSession().get(Cart.class,id);
	}

	@Transactional
	public double getTotalAmount(String username) 
	{
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price*quantity) from Cart where username=" + "'" + username + "' " ;
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (double) query.uniqueResult();
	}
	
	@Transactional
	public Cart deleteCartByUsername(String username) 
	{
		return null;
	}

	@Transactional
	public Integer getQuantity(String userID, String productName)
	{
		String hql = "select quantity from  MyCart where userID = ?  &&  productName =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userID);
		query.setString(1, productName);
		log.debug("Ending of the method getTotalAmount");
		return (Integer) query.uniqueResult();
	}
	
	public int getMaxId()
	{
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select max(id) from Cart");
		Integer maxid= (Integer)query.list().get(0);
		if (maxid==null)
			return 0;
		else
			return maxid;
	}
}
