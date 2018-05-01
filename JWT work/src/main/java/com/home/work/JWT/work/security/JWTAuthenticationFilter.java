package com.home.work.JWT.work.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.work.JWT.work.data.UserLogin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	 private AuthenticationManager authenticationManager;
	 
	 public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }
	 

	 @Override
	    public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {

		try {
			//UserLogin creds = new ObjectMapper().readValue(req.getInputStream(), UserLogin.class);
			UserLogin creds=new UserLogin( req.getParameter("username"),req.getParameter("password"));
			UsernamePasswordAuthenticationToken userCredentail = new UsernamePasswordAuthenticationToken(
					creds.getUsername(), creds.getPassword(), new ArrayList<>());

			return authenticationManager.authenticate(userCredentail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	 
	 
	 @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
		 HashMap<String,Object > claim= new HashMap();
		 claim.put("firstwork", "somevalue");
		 claim.put("role", "developer");
		 String token= Jwts.builder().setSubject(((User) auth.getPrincipal()).getUsername()).addClaims(claim)
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
	                .compact();
		 res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+ token);
	    

	 }
	 

}
