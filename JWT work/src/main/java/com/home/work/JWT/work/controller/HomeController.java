package com.home.work.JWT.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.work.JWT.work.data.UserInfo;
import com.home.work.JWT.work.data.intf.UserDetailInterface;

@RestController
@RequestMapping("/home") // if login prompted default id is user and the password look in logs
public class HomeController {
	@Autowired
	private UserDetailInterface userDetail;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
 
	
	
	
	
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	@ResponseBody
	public String saveUserData()
	
	{
		userDetail.save(new UserInfo("Rajeevan","Vazhakolil","vrrajeevan",bCryptPasswordEncoder.encode("rajeevan")));// firstname,lastname,username,pwd
		return "saved";
	}
	
	
	
	/* 
	 * User below url to login and get jwt token
	 * 
	 *  POST http://localhost:8080/login?username=vrrajeevan&password=rajeevan
	 *  
	 *  use the token received from above url and make below requests to get access
	 */
	
	
	@RequestMapping(value = "/user/getUserData", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserData()
	{
		return userDetail.findByUsername("vrrajeevan");
	}
	
	
	
	
}
