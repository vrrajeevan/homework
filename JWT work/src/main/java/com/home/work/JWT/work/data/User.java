package com.home.work.JWT.work.data;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor  
public class User {
	
	private String firstName;
	private String lastName;

	//User(){}
}
