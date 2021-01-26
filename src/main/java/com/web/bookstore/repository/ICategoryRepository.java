package com.web.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.bookstore.entity.CategoryEntity;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity,String> {

}
