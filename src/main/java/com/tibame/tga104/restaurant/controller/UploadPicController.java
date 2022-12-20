package com.tibame.tga104.restaurant.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.tibame.tga104.restaurant.service.MenuService;
import com.tibame.tga104.restaurant.service.RestaurantCarouselPicService;
import com.tibame.tga104.restaurant.service.RestaurantPostService;
import com.tibame.tga104.restaurant.vo.MenuVO;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;

@RestController
public class UploadPicController {
	
	@Autowired
	private RestaurantCarouselPicService carouselPicService;
	
	@PostMapping("/restaurant-uploadMultiplePics/{restaurantNo}")
	public void uploadMultiplePics(@PathVariable Integer restaurantNo,@RequestBody List<String> carouselPicStr) {
		for(String str : carouselPicStr) {
			RestaurantCarouselPicVO vo = new RestaurantCarouselPicVO();
			
			byte[] restaurantCarouselPic = Base64.getDecoder().decode(str);
			
			vo.setCarouselPic(restaurantCarouselPic);
			vo.setRestaurantNo(restaurantNo);
		
			carouselPicService.addRestaurantCarouselPic(vo);			
		}
		
		
	}
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/restaurant-uploadMenu")
	public void uploadMenu(@RequestBody MenuVO menu) {
		
		byte[] menuPic = Base64.getDecoder().decode(menu.getMenuPicstr());
		menu.setMenuPic(menuPic);
		menuService.addMenu(menu);
	}
	
	@Autowired
	private RestaurantPostService restaurantPostService;
	
	@PostMapping("/restaurant-uploadPost")
	public void uploadRestaurantPost(@RequestBody RestaurantPostVO post) {
		
		byte[] postPic = Base64.getDecoder().decode(post.getPostPicStr());
		post.setPostPic(postPic);
		restaurantPostService.addRestaurantPost(post);
	}
	

}
