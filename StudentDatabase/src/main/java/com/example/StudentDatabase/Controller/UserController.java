package com.example.StudentDatabase.Controller;

import java.util.Date;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.cglib.core.Signature;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentDatabase.Service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@PostMapping("login")
	public String Validate(@RequestBody User user)throws ServletException
	{
     	String jwtToken="";
		if(user.getUsername()==null || user.getPassword()==null)
		{
			throw new ServletException("please fill  in username and password");
			
		}
		String username= user.getUsername();
		String password= user.getPassword();
		User user1=(User) userService.login(username, password);
		if(user1== null)
		{
			throw new RuntimeException("user is empty");
		}
		jwtToken=Jwts.builder().setSubject(username).claim("userName",user.getName()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secretkey").compact();

	return jwtToken;
	}
	
}
