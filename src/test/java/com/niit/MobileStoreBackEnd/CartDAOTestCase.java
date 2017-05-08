package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileStoreBackEnd.dao.CartDAO;
import com.niit.MobileStoreBackEnd.domain.Cart;

public class CartDAOTestCase
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CartDAO cartDAO;
	@Autowired static Cart cart;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		cartDAO=(CartDAO) context.getBean("cartDAO");
		cart=(Cart) context.getBean("cart");
	}
	
	@Test
	public void createCartTestCase()
	{
		cart.setId("30");
		cart.setUser_id("Pratik");
		cart.setDate_added("24/09/1992");
		cart.setProduct_Id("1");
		cart.setQuantity("2");
		boolean flag=cartDAO.save(cart);
		
	    //assertEquals method
	    //error - if there are runtime errors         - red mark
	    //success - if expected and actual is same    - green mark
	    //fail - if expected and actual are different	- blue mark
		assertEquals("createCartTestCase",true,flag);
	}

}
