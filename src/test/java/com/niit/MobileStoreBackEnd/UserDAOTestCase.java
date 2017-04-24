package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileStoreBackEnd.dao.UserDAO;
import com.niit.MobileStoreBackEnd.domain.User;

public class UserDAOTestCase 
{
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static UserDAO userDAO;
	
    @Autowired static User user;
	
	//The above objects need to be initilialised
	
	//This method will be executed before calling any one of the test cases and only once
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get userDAO from context
		
		userDAO=(UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user=(User)context.getBean("user");
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("29");
		user.setName("Pratik");
		user.setPassword("123456");
		user.setRole("admin");
		boolean flag=userDAO.save(user);
		
	  //assertEquals method
	  //error - if there are runtime errors         - red mark
	  //success - if expected and actual is same    - green mark
	  //fail - if expected and actual are different	- blue mark
		assertEquals("createUserTestCase",true,flag);
	}
}
