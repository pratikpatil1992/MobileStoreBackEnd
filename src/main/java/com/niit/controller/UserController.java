package com.niit.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.niit.MobileStoreBackEnd.dao.UserDAO;
import com.niit.MobileStoreBackEnd.domain.User;

@Controller
public class UserController 
{	
	@Autowired UserDAO userDAO;
	@Autowired User user;
	
	
	//get userid and password from login page and send these values to userDAO.validate
	
	@RequestMapping("/validate")
	public ModelAndView login@RequestParam("userName") String id, @RequestParam("password") String password)
	{
		ModelAndView mv=new ModelAndView("/Home");
		if(userDAO.validate(id, password)==true)
		{
			user=userDAO.get(id);
			mv.addObject("message","Welcome "+user.getName());
		}
		else
			mv.addObject("message","Invalid credentials. Please try again.");	
		return mv;
	}
}
