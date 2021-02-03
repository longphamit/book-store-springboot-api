package com.web.bookstore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.bookstore.dto.MessageDTO;

@Configuration
@ComponentScan(basePackages = "com.web")
public class ServerConfig implements WebMvcConfigurer {
	// cau hinh chong cors
	// thong qua cors de test
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("*")// chi dinh domain truy cap
				.allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")// chi dinh phuong thuc truy cap
				.allowCredentials(false) // chi dinh cookie
				.maxAge(4800);// thoi gian toi da request dc luu lai. default 30 phut
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	@Scope("singleton")
	public MessageDTO messageDTO() {
		return new MessageDTO();
	}
	
}
