package com.web.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.bookstore.entity.AccountEntity;
import com.web.bookstore.repository.IAccountRepository;
import com.web.bookstore.service.IAccountServices;

@Service
public class AccountService implements IAccountServices{
	@Autowired
	IAccountRepository accountRepository;
	
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
	
}
