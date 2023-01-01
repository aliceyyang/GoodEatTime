package com.tibame.tga104.restaurant.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.JsonObject;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.restaurant.service.MenuService;
import com.tibame.tga104.restaurant.service.RestaurantCarouselPicService;
import com.tibame.tga104.restaurant.service.RestaurantPostService;
import com.tibame.tga104.restaurant.vo.MenuVO;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@RestController
public class UploadPicController {

	@Autowired
	private RestaurantCarouselPicService carouselPicService;

	@PostMapping("/restaurant-uploadMultiplePics/{restaurantNo}")
	public void uploadMultiplePics(HttpSession httpSession, @PathVariable Integer restaurantNo, @RequestBody List<String> carouselPicStr) {
		RestaurantMemberVO session = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		
		if (session != null) {
			restaurantNo = session.getRestaurantNo();
		}
		for (String str : carouselPicStr) {
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
	public void uploadMenu(HttpSession httpSession, @RequestBody MenuVO menu) {
		RestaurantMemberVO session = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		
		if (session != null) {
			menu.setRestaurantNo(session.getRestaurantNo());
		}
		byte[] menuPic = Base64.getDecoder().decode(menu.getMenuPicstr());
		menu.setMenuPic(menuPic);
		menuService.addMenu(menu);
	}

	@Autowired
	private RestaurantPostService restaurantPostService;

	@PostMapping("/restaurant-uploadPost")
	public boolean uploadRestaurantPost(HttpSession httpSession, @RequestBody RestaurantPostVO post) {
		RestaurantMemberVO session = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		
		if (session != null) {
			post.setRestaurantNo(session.getRestaurantNo());
		}
		byte[] postPic = Base64.getDecoder().decode(post.getPostPicStr());
		post.setPostPic(postPic);
		return restaurantPostService.addRestaurantPost(post);
	}

}
