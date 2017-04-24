package com.niit.MobileStoreBackEnd.dao;

import java.util.*;

import com.niit.MobileStoreBackEnd.domain.User;

public interface UserDAO
{
	//declare methods
	//declare operations
	//1)create/register - save
	//2)update the user details - update
	//3)validate credentials - validate
	//4)get all users - list
	
	//declare methods with proper signature
	//access_specifier return_type methodName(parameter_list) throws exception_list
	
	public boolean save(User user);
	public boolean update(User user);
	public boolean validate(String id,String password);
	
	public List<User> list ();  //no parameters because we want list of all users
	
	public User get(String id);  //get details based on userId
	
}
