package com.web.bookstore.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.bookstore.entity.AccountEntity;

public interface IAccountServices {
	public List<AccountEntity> getAccountsBlocked();// blocked
	public List<AccountEntity> getAccounts(); //not blocked
	public boolean removeAnAccount(String username);
	public boolean blockAnAccount(String username);
}
