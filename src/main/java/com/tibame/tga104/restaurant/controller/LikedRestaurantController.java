package com.tibame.tga104.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.restaurant.service.LikedRestaurantService;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

@RestController
public class LikedRestaurantController {
	
	@Autowired
	private LikedRestaurantService service;
	
	//加入最愛餐廳
	@PostMapping("/LikedRestaurant-add")
	public boolean addLikedRestaurant(@RequestBody LikedRestaurantVO likedRestaurantVO) {
		return service.addLikedRestaurant(likedRestaurantVO);
	}
	
	//刪除最愛餐廳
	@DeleteMapping("/LikedRestaurant-delete")
	public void deleteLikedRestaurant(@RequestBody LikedRestaurantVO likedRestaurantVO) {
		service.deleteLikedRestaurant(likedRestaurantVO);
	}
	
	//列出該會員所有最愛餐廳
	@GetMapping("/LikedRestaurant-list/{memberNo}")
	public List<LikedRestaurantVO> getListLikedRestaurant(@PathVariable Integer memberNo){
		return service.getListLikedRestaurant(memberNo);
	}

}
