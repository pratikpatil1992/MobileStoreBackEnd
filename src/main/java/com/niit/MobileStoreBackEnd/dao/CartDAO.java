package com.niit.MobileStoreBackEnd.dao;

import java.util.List;

import com.niit.MobileStoreBackEnd.domain.Cart;

public interface CartDAO 
{
	public List<Cart> list();
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean empty(String id);
	public Cart getCartById(String id);
}
