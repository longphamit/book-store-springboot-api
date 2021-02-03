package com.web.bookstore.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.web.bookstore.dto.AuthenticateDTO;

import com.web.bookstore.service.IAccountServices;
import com.web.bookstore.util.JWTUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	Logger logger= LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	IAccountServices accountServices;
	@Autowired
	AuthenticationManager authentication;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Object object){
		try {
			JSONObject jsonObject= new JSONObject(new Gson().toJson(object));
			String username=jsonObject.getString("username");
			String password=jsonObject.getString("password");
			
			Authentication authentication= authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username,password)
					
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			AuthenticateDTO authenticateDTO= new AuthenticateDTO();
			authenticateDTO.setUsername(username);
			authenticateDTO.setRole("ROLE_USER");
			String jwt=JWTUtil.createJWT(authenticateDTO);
			
			logger.info("Xac thuc thanh cong");
			return new ResponseEntity<String>(jwt,HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Xac thuc that bai");
		}
		return new ResponseEntity<String>("Error",HttpStatus.OK);
	}
	
}
