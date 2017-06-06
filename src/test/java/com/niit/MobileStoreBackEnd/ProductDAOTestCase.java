package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileStoreBackEnd.dao.ProductDAO;
import com.niit.MobileStoreBackEnd.domain.Product;

public class ProductDAOTestCase 
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static ProductDAO productDAO;
	@Autowired static Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
		product=(Product) context.getBean("product");
	}
	
	@Test
	public void createProductTestCase()
	{
		product.setId("motog3");
		product.setName("Moto G3");
		product.setDescription("Moto G3");
		product.setPrice(10000);
		product.setCategory_id("motog3");
		product.setSupplier_id("moto supplier");
		boolean flag=productDAO.save(product);
		
	  //assertEquals method
	  //error - if there are runtime errors         - red mark
	  //success - if expected and actual is same    - green mark
	  //fail - if expected and actual are different	- blue mark
		assertEquals("createProductTestCase",true,flag);
	}
}
