package com.web.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.bookstore.entity.AccountEntity;
import com.web.bookstore.entity.CategoryEntity;
import com.web.bookstore.repository.ICategoryRepository;
import com.web.bookstore.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> listAllCategory() {
		return categoryRepository.findAll();
	}


	@Override
	public void removeCategory(String id) {
		categoryRepository.removeById(id);
	}

	@Override
	public boolean updateCategory(String id, String name) {
		CategoryEntity categoryEntity= new CategoryEntity();
		categoryEntity.setId(id);
		categoryEntity.setName(name);
		CategoryEntity result= categoryRepository.save(categoryEntity);
		if(result!=null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean createNewCategory(String name) {
		CategoryEntity categoryEntity= new CategoryEntity();
		categoryEntity.setId(UUID.randomUUID().toString());
		categoryEntity.setName(name);
		CategoryEntity result= categoryRepository.save(categoryEntity);
		if(result!=null) {
			return true;
		}else {
			return false;
		}
		 
	}

}
