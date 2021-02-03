package com.web.bookstore.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.web.bookstore.entity.AccountEntity;

public interface IAccountRepository extends JpaRepository<AccountEntity, String> {
	//Get accounts are blocked or not blocked
	//True -> not blocked
	//False -> blocked
//	@Query("Select from AccounEntity where isNotBlocked=: isNotBlocked ")
//	public List<AccountEntity> getAccountByBlockedStatus(@Param("isNotBlocked") boolean isNotBlocked);
//	
//	//Block an account
//	@Query("Update AccountEntity set isNotBlocked=false where username=:username ")
//	public boolean blockAnAccount(@Param("username")String username);
//	
//	//Remove an account
//	@Query("Delete from AccountEntity where username=:username")
//	public boolean removeAnAccount(@Param("username")String username);
	
	//loginByUserName
	
	public AccountEntity findByUserName(String username);
}
