package com.web.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.bookstore.dto.AccountDTO;
import com.web.bookstore.entity.CategoryEntity;

@Repository // nay la daook ranh thi viet sql ko thi no tu lam may cai don gian // may cai nhu repository hay service phai khai bao annotation cho no
// muc dich de no autowired lai trong cai goi la Ioc
public interface ICategoryRepository extends JpaRepository<CategoryEntity,String> {
	@Modifying
	@Query("select * from CategoryEntity where id =:id") // cai nay la truyen tham so vaook
	public Optional<CategoryEntity> findById(@Param("id") String id);
	
	@Modifying
	@Query("delete from CategoryEntity where id=:id")
	public void removeById(@Param("id")String id);
	
}
