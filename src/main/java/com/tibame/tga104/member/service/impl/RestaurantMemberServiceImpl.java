package com.tibame.tga104.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.member.dao.RestaurantMemberDAO;
import com.tibame.tga104.member.service.RestaurantMemberService;
import com.tibame.tga104.member.vo.RestaurantMemberVO;

@Service
@Transactional
public class RestaurantMemberServiceImpl implements RestaurantMemberService{

	@Autowired
	private RestaurantMemberDAO dao;
	
//===============會員登入===============
	@Override
	public RestaurantMemberVO restaurantMemberLogin(RestaurantMemberVO restaurantMemberVO) {
		if (restaurantMemberVO.getRestaurantAccount()== null || restaurantMemberVO.getRestaurantAccount().isEmpty()) {
			restaurantMemberVO.setMessage("帳號必須輸入");
		}
		if (restaurantMemberVO.getRestaurantPassword()== null || restaurantMemberVO.getRestaurantPassword().isEmpty()) {
			restaurantMemberVO.setMessage("密碼必須輸入");
		}
		if (restaurantMemberVO.getMessage()!=null) {
			return restaurantMemberVO;
		}
		restaurantMemberVO = dao.selectForLogin(restaurantMemberVO.getRestaurantAccount(), restaurantMemberVO.getRestaurantPassword());
		if (restaurantMemberVO != null) {
			restaurantMemberVO.setSuccessful(true);
			restaurantMemberVO.setMessage("登入成功");
		}else {
			restaurantMemberVO = new RestaurantMemberVO();
			restaurantMemberVO.setSuccessful(false);
			restaurantMemberVO.setMessage("登入失敗");
		}
		
		return restaurantMemberVO;
	}

}
