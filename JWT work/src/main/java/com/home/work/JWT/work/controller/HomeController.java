package com.home.work.JWT.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.work.JWT.work.data.User;
import com.home.work.JWT.work.data.intf.UserInterface;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserInterface user;
	

	@RequestMapping(value = "/user/save", method = RequestMethod.GET)
	@ResponseBody
	public String saveUserData()
	
	{
		user.save(new User("Rajeevan","Vazhakolil","vrrajeevan"));
		return "saved";
	}
	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	@ResponseBody
	public User getUserData()
	{
		return user.findByUserId("vrrajeevan");
	}
	
	
	
	
}
