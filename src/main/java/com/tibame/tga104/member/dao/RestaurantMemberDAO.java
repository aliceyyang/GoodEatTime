package com.tibame.tga104.member.dao;


import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.member.vo.RestaurantRegistVO;

public interface RestaurantMemberDAO {
	
//餐廳會員登入
	public abstract RestaurantMemberVO selectForLogin(String restaurantAccount, String restaurantPassword);
	
//餐廳會員註冊
	public abstract RestaurantRegistVO insert(RestaurantRegistVO restaurantRegistVO);
	
	RestaurantRegistVO selectByAccount(String restaurantAccount);
}
