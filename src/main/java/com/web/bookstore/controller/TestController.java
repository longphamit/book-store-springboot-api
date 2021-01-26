package com.web.bookstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.bookstore.entity.CategoryEntity;
import com.web.bookstore.service.ICategoryService;

@RestController
@RequestMapping("/api/book_store/test")
public class TestController {
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	ICategoryService categoryService;
	@RequestMapping("/search")
	public Object listAllCategory() {
		log.info("get all category");
		return new ResponseEntity<List<CategoryEntity>>(categoryService.listAllCategory(),HttpStatus.OK); 
	}
}
