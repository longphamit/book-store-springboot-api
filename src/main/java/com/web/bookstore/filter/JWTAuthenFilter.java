package com.web.bookstore.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.google.gson.Gson;
import com.web.bookstore.dto.AuthenticateDTO;
import com.web.bookstore.service.IAccountServices;
import com.web.bookstore.util.JWTUtil;

public class JWTAuthenFilter extends BasicAuthenticationFilter {
	@Autowired
	IAccountServices accountService;
	public JWTAuthenFilter(AuthenticationManager authenticationManager,
			IAccountServices accountService) {
		super(authenticationManager);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String tokenBearer=request.getHeader("Authorization");
		// xac thuc token
		if(tokenBearer!=null&&tokenBearer.startsWith("Bearer")) {
			String subject=JWTUtil.verifyToken(tokenBearer);
			AuthenticateDTO authenticateDTO=new Gson().fromJson(subject, AuthenticateDTO.class);
			UserDetails userDetailSecurity=accountService.loadUserByUsername(authenticateDTO.getUsername());
			UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetailSecurity,null, userDetailSecurity.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		
		chain.doFilter(request, response);
	}
		
	
	

}
