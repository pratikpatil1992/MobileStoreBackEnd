package com.niit.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.CartDAO;
import com.niit.MobileStoreBackEnd.domain.Cart;
import com.niit.MobileStoreBackEnd.domain.Product;
import com.niit.MobileStoreBackEnd.domain.Cart;

@Repository("cartDAO")     //to create singleton instance
@Transactional

public class CartDAOImpl implements CartDAO
{
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

	public boolean update(Cart cart) 
	{
		return false;
	}

	public boolean empty(String id) 
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

	public Cart getCartById(String id) 
	{
		return (Cart) getCurrentSession().get(Cart.class,id);
	}

}
