package com.niit.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.UserDAO;
import com.niit.MobileStoreBackEnd.domain.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(User user) 
	{
		System.out.println("Hi");
		try
		{
			Session session =sessionFactory.openSession();
			session.save(user);
			session.flush();
			session.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//"save" method updates a record in User table
	//if the record is updated successfully, return true, else false
	public boolean update(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String username, String password)
	{
		Query query=sessionFactory.getCurrentSession().createQuery("from User where username=? and password=?");
		query.setString(0,username);     //index starts from zero => will get an exception once
		query.setString(1,password);
		//in the user table, with this id and password, there will be one or zero records
		//i.e. unique result method will return object if a row exists, or else null
		if(query.uniqueResult()==null)
			return false;    //no row exists i.e. invalid credentials
		else
			return true;     //row exists i.e. valid credentials
	}
	public List<User> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from user").list();
	}
	
	public User get(String username) 
	{
		return (User)sessionFactory.getCurrentSession().get(User.class,username);
	}
	
}