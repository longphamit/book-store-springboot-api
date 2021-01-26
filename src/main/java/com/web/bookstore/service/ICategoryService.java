package com.web.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.bookstore.entity.CategoryEntity;


public interface ICategoryService {
	public List<CategoryEntity> listAllCategory();
}
