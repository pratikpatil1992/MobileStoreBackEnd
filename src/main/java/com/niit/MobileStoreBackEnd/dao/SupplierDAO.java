package com.niit.MobileStoreBackEnd.dao;

import java.util.List;

import com.niit.MobileStoreBackEnd.domain.Supplier;

public interface SupplierDAO 
{
	public List<Supplier> list();
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(String id);
	public Supplier getSupplierById(String id);
	public Supplier getSupplierByName(String name);
}
