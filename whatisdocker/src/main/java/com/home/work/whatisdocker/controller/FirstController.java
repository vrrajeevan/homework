package com.home.work.whatisdocker.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class FirstController {
	
@RequestMapping(value="/hi", method = RequestMethod.GET)
  public String FirstHandle() throws UnknownHostException
  {
	  return  "Give some thing back"+ "Test how docker works " + InetAddress.getLocalHost().getHostAddress();
  }
	
}
