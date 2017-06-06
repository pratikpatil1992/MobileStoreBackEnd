package com.niit.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.CategoryDAO;
import com.niit.MobileStoreBackEnd.domain.Category;

@Repository("categoryDAO")     //to create singleton instance
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<Category> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	public boolean save(Category category)
	{
		try
		{
			getCurrentSession().save(category);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) 
	{
		try
		{
			getCurrentSession().update(category);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String id) 
	{
		try
		{
			getCurrentSession().delete(getCategoryById(id));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Category getCategoryById(String id)
	{
		return (Category) getCurrentSession().get(Category.class,id);
	}
	
	public Category getCategoryByName(String name) 
	{
		return (Category) getCurrentSession().createQuery("from Category where name=?").setString(0,name).uniqueResult();
	}
	
}
