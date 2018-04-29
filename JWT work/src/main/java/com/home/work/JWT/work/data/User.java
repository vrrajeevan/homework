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
public class User {
	 @Id
	  @GeneratedValue
	  @Column(name="id")
	private Long id;
	 @Column(name="firstName")
	private String firstName;
	 @Column(name="lastName")
	private String lastName;
    
	 @Column(name="userId")
	private String userId;
	    
	public User(){}

	public User(String firstName, String lastName, String userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
	}
}
