package com.tibame.tga104.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.service.RestaurantMemberService;
import com.tibame.tga104.member.vo.RestaurantRegistVO;

@RestController

public class RestaurantMemberRegistController {

	@Autowired
	private RestaurantMemberService restaurantMemberService;
	
	@PostMapping("/restaurantregister")
	public RestaurantRegistVO register(@RequestBody RestaurantRegistVO restaurantRegistVO) {
		if (restaurantRegistVO == null) {
			restaurantRegistVO = new RestaurantRegistVO();
			restaurantRegistVO.setSuccessful(false);
			restaurantRegistVO.setMessage("註冊失敗");
			return restaurantRegistVO;
		}else {
			restaurantRegistVO = restaurantMemberService.restaurantMemberRegist(restaurantRegistVO);
		}
		return restaurantRegistVO;
	}
	
	
}
