package com.home.work.JWT.work.security;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.home.work.JWT.work.data.UserInfo;
import com.home.work.JWT.work.data.intf.UserDetailInterface;


/**
 * @author vrrajeevan
 * implement the UserDetailsService  make's use UserDetailInterface JPA  and retrives 
 * the user info from the database
 */
@Service
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

//	@Autowired
	UserDetailInterface loginInterface;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 UserInfo userinfo= loginInterface.findByUsername(userName);
		  if (userinfo == null) {
	            throw new UsernameNotFoundException(userName);
	        }
		  
		  return new User(userinfo.getUsername(), userinfo.getPassword(), Collections.emptyList());
	}
	
	public UserDetailsServiceImpl(UserDetailInterface loginInterface)
	{
		this.loginInterface=loginInterface;
	}

}
