package com.niit.MobileStoreBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobileStoreBackEnd.dao.SupplierDAO;
import com.niit.MobileStoreBackEnd.domain.Supplier;

public class SupplierDAOTestCase 
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static SupplierDAO supplierDAO;
	@Autowired static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier=(Supplier) context.getBean("supplier");
	}
	
	@Test
	public void createSupplierTestCase()
	{
		supplier.setId("123");
		supplier.setName("A");
		supplier.setAddress("Panvel");
		boolean flag=supplierDAO.save(supplier);
		
	  //assertEquals method
	  //error - if there are runtime errors         - red mark
	  //success - if expected and actual is same    - green mark
	  //fail - if expected and actual are different	- blue mark
		assertEquals("createSupplierTestCase",true,flag);
	}
}