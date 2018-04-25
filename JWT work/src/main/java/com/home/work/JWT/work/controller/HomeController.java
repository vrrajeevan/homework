package com.home.work.JWT.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.work.JWT.work.data.User;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public User getUserData()
	{
		return new User("Rajeevan","Vazhakolil");
	}
	
}
