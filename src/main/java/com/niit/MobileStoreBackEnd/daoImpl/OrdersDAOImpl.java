package com.niit.MobileStoreBackEnd.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MobileStoreBackEnd.dao.OrdersDAO;
import com.niit.MobileStoreBackEnd.domain.Orders;

@Repository("ordersDAO")     //to create singleton instance
@Transactional

public class OrdersDAOImpl implements OrdersDAO
{

	@Autowired private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
		
	public boolean save(Orders orders)
	{
		try
		{
			getCurrentSession().save(orders);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int getMaxId()
	{
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select max(id) from Orders");
		Integer maxid= (Integer)query.list().get(0);
		if (maxid==null)
			return 0;
		else
			return maxid;
	}
}
