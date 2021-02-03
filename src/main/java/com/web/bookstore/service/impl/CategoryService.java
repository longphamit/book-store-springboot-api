package com.web.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

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
	public boolean createNewCategory(String name) {
		String id = UUID.randomUUID().toString().substring(0, 20);
		return categoryRepository.createNewCategory(id, name);
	}

	@Override
	public boolean removeCategory(String id) {
		return categoryRepository.removeAccount(id);
	}

	@Override
	public boolean updateCategory(String id, String name) {
		return categoryRepository.updateAccount(id, name);
	}

}
