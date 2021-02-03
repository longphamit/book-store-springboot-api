package com.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.web.bookstore.entity.AccountEntity;
import com.web.bookstore.repository.IAccountRepository;


@SpringBootApplication
public class BookStoreSpringbootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreSpringbootApiApplication.class, args);
	}
	

}
