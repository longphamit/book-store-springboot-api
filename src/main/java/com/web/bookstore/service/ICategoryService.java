package com.web.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.bookstore.entity.CategoryEntity;


public interface ICategoryService {
	public List<CategoryEntity> listAllCategory();
	public boolean createNewCategory(String name);
	public void removeCategory(String id);
	public boolean updateCategory(String id, String name);
	
}
