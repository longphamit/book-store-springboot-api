package com.web.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.web.bookstore.filter.JWTAuthenFilter;
import com.web.bookstore.service.IAccountServices;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	IAccountServices accountService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
		
	}
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()// tat csrf
		.cors().disable() // tat cors: bảo mật cors kiem tra cac request tu cac server khong được phép// dang test nên phải tắt
		.antMatcher("/api/**")
		.authorizeRequests()
		.antMatchers("/api/login","/api/register")
		.permitAll()
		.anyRequest()
		.authenticated();
		// cau hinh khong su dung session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// cau hinh filter
		http.addFilter(new JWTAuthenFilter(authenticationManager(), accountService));
		
	}
}
