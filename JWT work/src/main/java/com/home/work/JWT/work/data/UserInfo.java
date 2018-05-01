package com.home.work.JWT.work.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor  
@Entity
@Table(name = "User")
public class UserInfo {
	 @Id
	  @GeneratedValue
	  @Column(name="id")
	private Long id;
	 @Column(name="firstname")
	private String firstName;
	 @Column(name="lastname")
	private String lastName;
    
	 @Column(name="username")
	private String username;
	    
	 @Column(name="password")
		private String password;
	public UserInfo(){}

	public UserInfo(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
	}
}
