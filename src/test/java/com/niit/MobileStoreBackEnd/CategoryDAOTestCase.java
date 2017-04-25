package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileStoreBackEnd.dao.CategoryDAO;
import com.niit.MobileStoreBackEnd.domain.Category;

public class CategoryDAOTestCase 
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		category=(Category) context.getBean("category");
	}
	
}
