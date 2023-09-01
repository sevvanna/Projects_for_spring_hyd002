package com.example.StudentDatabase.config;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtFilter extends GenericFilterBean {

	
		// TODO Auto-generated constructor stub
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest request= (HttpServletRequest)req;
		final HttpServletResponse response=(HttpServletResponse)res;
				
		final String authheader=request.getHeader("Authorization");
		try
		{
		if(authheader==null||!authheader.startsWith("Bearer"))
		{
			throw new ServletException("Missing or Invalid Authorization");
		}
		final String token=authheader.substring(7);
        Claims claims = Jwts.parser().
                setSigningKey("secretkey") 
                .parseClaimsJws(token)
                .getBody();
        request.setAttribute("claims",claims);
        //String username = claims.getSubject();
		}
		catch(final SignatureException e)
		{
			throw new ServletException("Invalid token");
		}
		chain.doFilter(request, response);

		// TODO Auto-generated method stub
		
	}

}
