package com.home.work.JWT.work.data.intf;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.work.JWT.work.data.User;

public interface UserInterface extends JpaRepository<User, String> {

	
	User findByUserId(String userId);// extend new f
	

}
