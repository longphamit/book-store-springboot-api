package com.web.bookstore.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.bookstore.entity.CategoryEntity;
import com.web.bookstore.service.ICategoryService;

@RestController // spring boot neu dung de viet api thi xai RestController no se ko yeu cau tra ve string de mapping qua trrang nhu strut 2 ma tra ve json
@RequestMapping("/api/book_store/test") // cai duong dan la http:localhost:8080:/ sau do ko co gi het nen minh map the nay
public class TestController {
	private static final Logger log = LoggerFactory.getLogger(TestController.class); // ghi log bang log4j

	@Autowired
	ICategoryService categoryService;
	@GetMapping("/search") // / cai o tren xong /search thi no chay cai ham nay
	// ngoai ra minh co the quy dinh phuong thuc nhan cua ham oke ok
	// a con cai nay
	public Object listAllCategory() {
		log.info("get all category");
		return new ResponseEntity<List<CategoryEntity>>(categoryService.listAllCategory(),HttpStatus.BAD_GATEWAY); // cai nay la gui kem theo http status 
	}
	
	//minh se dung post nhu the nay
	@PostMapping("/add_category")//cai nay la lay  doi tuong tu body request cua post, nhung ma sao biet no la categoryEntity luon ma khai bao ?
	// de tui xem lai thu maybe no tu dong mapping nhung mma cai api nay la ben client phai gui dung ko dc gui sai
	// minh co the dung cai nay
	public Object addCategory(@RequestBody CategoryEntity categoryEntity) {
		// thuong thi voi spring boot no se co them 1 thang dto
		// chu ko xai entity nay// entity no load du lieu duoi database len xong do vao dto
		// 
		return new ResponseEntity<List<CategoryEntity>>(categoryService.listAllCategory(),HttpStatus.BAD_GATEWAY); 
	}
	@GetMapping("/get_by_id/{id}")
	public Object getById(@PathParam("id") String id) {
		//cai nay la lay param tu get, roi tip di ,nay giong nodejs
		// cho xiu
		return null;
	}
	// roi trc mat v di mai len trello coi taskokokokokok
	
	
//	@RequestMapping("/delete")
//	public Object delete() {
//		
//	} // vi luc nay cau hinh show sql nen no show ra the nay
	// o tren co ghi log lai
}
