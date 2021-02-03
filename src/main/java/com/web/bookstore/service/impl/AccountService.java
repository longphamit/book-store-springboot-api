package com.web.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.bookstore.dto.AccountDTO;
import com.web.bookstore.entity.AccountEntity;
import com.web.bookstore.repository.IAccountRepository;
import com.web.bookstore.service.IAccountServices;

@Service
public class AccountService implements IAccountServices{
	@Autowired
	IAccountRepository accountRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
//	@Override
//	public List<AccountEntity> getAccountsBlocked() {
//		return accountRepository.getAccountByBlockedStatus(false);
//	}
//	@Override
//	public List<AccountEntity> getAccounts() {
//		return accountRepository.getAccountByBlockedStatus(true);
//	}
//	@Override
//	public boolean removeAnAccount(String username) {
//		return accountRepository.removeAnAccount(username);
//	}
//	@Override
//	public boolean blockAnAccount(String username) {
//		return accountRepository.blockAnAccount(username);
//	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity accountEntity=accountRepository.findByUserName(username);
		if(accountEntity==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return accountEntity;
	}

	@Override
	public AccountEntity createAccount(AccountDTO accountDTO) {
		AccountEntity accountEntity=modelMapper.map(accountDTO, AccountEntity.class);
		accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
		accountEntity.setId(UUID.randomUUID().toString());
		return accountRepository.save(accountEntity);
	}
	
}
