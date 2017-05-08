package com.niit.MobileStoreBackEnd.dao;

import java.util.List;

import com.niit.MobileStoreBackEnd.domain.Category;

public interface CategoryDAO
{
	public List<Category> list();
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String id);
	public Category getCategoryById(String id);
	public Category getCategoryByName(String name);
	
	
}
