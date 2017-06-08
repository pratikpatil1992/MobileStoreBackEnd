package com.niit.MobileStoreBackEnd.dao;

import java.util.*;

import com.niit.MobileStoreBackEnd.domain.User;

public interface UserDAO
{
	
	public boolean save(User user);
	public boolean update(User user);
	public boolean validate(String username,String password);
	
	public List<User> list ();  //no parameters because we want list of all users
	
	public User get(String username);  //get details based on userId
	public String getAddressByUsername(String username);
}
