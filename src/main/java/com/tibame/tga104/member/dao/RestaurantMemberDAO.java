package com.tibame.tga104.member.dao;


import com.tibame.tga104.member.vo.RestaurantMemberVO;

public interface RestaurantMemberDAO {
	
//會員登入
	public abstract RestaurantMemberVO selectForLogin(String restaurantAccount, String restaurantPassword);

}
