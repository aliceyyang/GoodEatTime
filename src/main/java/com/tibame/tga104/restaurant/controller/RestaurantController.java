package com.tibame.tga104.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.restaurant.service.RestaurantService;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
//	查詢所有餐廳
	@GetMapping("/restaurant-read")
	public ResponseEntity<List<RestaurantVO>> getByAll() {
		List<RestaurantVO> list = restaurantService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
//	輸入餐廳編號查詢
	@GetMapping("/restaurant-read/{restaurantNo}")
	public ResponseEntity<RestaurantVO> getByRestaurantNo(@PathVariable Integer restaurantNo) {
		RestaurantVO vo = restaurantService.getOneRestaurant(restaurantNo);
		return ResponseEntity.status(HttpStatus.OK).body(vo);
	}
	
//	新增餐廳
	@PostMapping("/restaurant-create")
	public ResponseEntity<Boolean> createRestaurant(@RequestBody RestaurantVO restaurant) {
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(restaurant));
	}
	
//	餐廳方更新自己餐廳資料
	@PutMapping("/restaurant-update/{restaurantNo}")
	public ResponseEntity<RestaurantVO>  updateRestaurant(@PathVariable Integer restaurantNo,
								   						  @RequestBody RestaurantVO restaurant) {
		
		RestaurantVO vo = 
		restaurantService.updateRestaurant(restaurant.getRestaurantTel(), restaurant.getRestaurantName(), restaurant.getRestaurantTaxIDNo(), 
				restaurant.getRestaurantAccountInfo(), restaurant.getRestaurantBusinessHour(), restaurant.getRestaurantAddr(), 
				restaurant.getRestaurantAccount(), restaurant.getRestaurantPassword(), restaurantNo);
		return ResponseEntity.status(HttpStatus.OK).body(vo);
	}
	
	
//	管理員更新餐廳狀態
	@PutMapping("restaurant-setStatus/{restaurantNo}")
	public void changeStatus(@PathVariable Integer restaurantNo,
							 @RequestBody Boolean restaurantStatus) {
		restaurantService.setStatus(restaurantNo, restaurantStatus);
	}
	
	

}
