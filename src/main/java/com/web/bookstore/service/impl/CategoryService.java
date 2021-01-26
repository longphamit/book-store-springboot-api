package com.web.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.bookstore.entity.CategoryEntity;
import com.web.bookstore.repository.ICategoryRepository;
import com.web.bookstore.service.ICategoryService;
@Service
public class CategoryService implements ICategoryService{

	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public List<CategoryEntity> listAllCategory() {
		return categoryRepository.findAll();
	}

}
