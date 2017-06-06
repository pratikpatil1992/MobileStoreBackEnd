package com.niit.MobileStoreBackEnd.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.niit.MobileStoreBackEnd.domain.Product;

public interface ProductDAO
{
	public List<Product> list();
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String id);
	public Product getProductById(String id);
	public Product getProductByName(String name);
	public void storeFile(Product product, HttpServletRequest request);
	public List<Product> search(String productName);
}
