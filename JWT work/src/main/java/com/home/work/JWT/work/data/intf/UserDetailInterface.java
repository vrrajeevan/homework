package com.home.work.JWT.work.data.intf;

import org.springframework.data.jpa.repository.JpaRepository;


import com.home.work.JWT.work.data.UserInfo;

public interface UserDetailInterface extends JpaRepository<UserInfo, String> {

	
	UserInfo findByUsername(String userName);// extend new f
	

}
