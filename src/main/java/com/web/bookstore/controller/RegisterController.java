package com.web.bookstore.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.web.bookstore.dto.AccountDTO;
import com.web.bookstore.dto.AuthenticateDTO;
import com.web.bookstore.dto.MessageDTO;
import com.web.bookstore.entity.AccountEntity;
import com.web.bookstore.service.IAccountServices;
import com.web.bookstore.util.JWTUtil;

@RestController
@RequestMapping("/api")
public class RegisterController {
	@Autowired
	IAccountServices accountService;
	@Autowired
	MessageDTO messageDTO;
	@PostMapping("/register")
	public ResponseEntity<Object> registerAccount(@RequestBody AccountDTO accountDTO){
		AccountEntity accountEntity=accountService.createAccount(accountDTO);
		JSONObject jsonObject= new JSONObject();
		if(accountEntity==null) {
			messageDTO.createReturn("Register fail", false, new JSONArray());
			return new ResponseEntity<Object>(messageDTO.getResult(),HttpStatus.BAD_REQUEST);
		}else {
			AuthenticateDTO authenticateDTO= new AuthenticateDTO();
		
			authenticateDTO.setUsername(accountEntity.getUsername());
			authenticateDTO.setRole(accountEntity.getRole());
			String jwt =JWTUtil.createJWT(authenticateDTO);
			JSONArray array= new JSONArray();
			array.put(jwt);
			array.put(authenticateDTO);
			messageDTO.createReturn("Register success",true,array);
		}
		return new ResponseEntity<Object>(messageDTO.getResult(),HttpStatus.ACCEPTED);
		
	}	
}
