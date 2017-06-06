package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

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
		cart.setId(1);
		cart.setUsername("pratikpatil");
		cart.setProduct_Id("1");
		cart.setQuantity(1);
		cart.setProduct_Name("Moto G2");
		cart.setPrice(10000);
		boolean flag=cartDAO.save(cart);
		
	    //assertEquals method
	    //error - if there are runtime errors         - red mark
	    //success - if expected and actual is same    - green mark
	    //fail - if expected and actual are different	- blue mark
		assertEquals("createCartTestCase",true,flag);
	}

}
