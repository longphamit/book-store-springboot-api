package com.web.bookstore.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.bookstore.dto.AccountDTO;
import com.web.bookstore.entity.CategoryEntity;

@Repository // nay la daook ranh thi viet sql ko thi no tu lam may cai don gian // may cai nhu repository hay service phai khai bao annotation cho no
// muc dich de no autowired lai trong cai goi la Ioc
public interface ICategoryRepository extends JpaRepository<CategoryEntity,String> {
	
//	@Query("select * from CategoryEntity where id =:id") // cai nay la truyen tham so vaook
//	public List<CategoryEntity> findAll(@Param("id") String id);
	
	@Query("insert into CategoryEntity(id,name) values(:id,:name)")
	public boolean createNewCategory(@Param("id")String id, @Param("name")String name);
	
	@Query("delete from CategoryEntity where id=:id")
	public boolean removeAccount(@Param("id")String id);
	
	@Query("update CategoryEntity set name=:name where id=:id")
	public boolean updateAccount(@Param("id")String id, @Param("name")String name);
}
