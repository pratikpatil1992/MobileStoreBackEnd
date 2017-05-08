package com.niit.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.ProductDAO;
import com.niit.MobileStoreBackEnd.domain.Product;

@Repository("productDAO")     //to create singleton instance
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired private SessionFactory sessionFactory;	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
		
	public List<Product> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
		
	public boolean save(Product product)
	{
		try
		{
			getCurrentSession().save(product);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product product) 
	{
		return false;
	}

	public boolean delete(String id) 	
	{
		try
		{
			getCurrentSession().delete(getProductById(id));
		} 
		catch (Exception e)
		{				
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Product getProductById(String id)
	{
		return (Product) getCurrentSession().get(Product.class,id);
	}
		
	public Product getProductByName(String name) 
	{
		return (Product) getCurrentSession().createQuery("from Product where name=?").setString(0,name).uniqueResult();
	}
}
