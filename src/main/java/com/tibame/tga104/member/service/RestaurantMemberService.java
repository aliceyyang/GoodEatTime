package com.tibame.tga104.member.service;

import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.member.vo.RestaurantRegistVO;

public interface RestaurantMemberService {
	
	RestaurantMemberVO restaurantMemberLogin(RestaurantMemberVO restaurantMemberVO);
	
	RestaurantRegistVO restaurantMemberRegist(RestaurantRegistVO restaurantRegistVO);
}
