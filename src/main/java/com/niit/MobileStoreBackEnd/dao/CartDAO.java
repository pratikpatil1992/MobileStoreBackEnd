package com.niit.MobileStoreBackEnd.dao;

import java.util.List;

import com.niit.MobileStoreBackEnd.domain.Cart;

public interface CartDAO 
{
	public List<Cart> list();
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(int id);
	public Cart getCartById(int id);
	public Cart deleteCartByUsername(String username);
	public int getMaxId();
	public double getTotalAmount(String id);
	public Integer getQuantity(String userID, String productName);
}
