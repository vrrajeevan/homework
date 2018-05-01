package com.home.work.JWT.work.data.intf;

import org.springframework.data.jpa.repository.JpaRepository;


import com.home.work.JWT.work.data.UserInfo;
import com.home.work.JWT.work.data.UserLogin;

public interface UserLoginInterface extends JpaRepository<UserInfo, String>  {

	
	UserLogin findByUsername(String userId);// extend new f
	

}
