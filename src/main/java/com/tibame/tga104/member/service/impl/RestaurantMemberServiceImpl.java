package com.tibame.tga104.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.member.dao.RestaurantMemberDAO;
import com.tibame.tga104.member.service.RestaurantMemberService;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.member.vo.RestaurantRegistVO;

@Service
@Transactional
public class RestaurantMemberServiceImpl implements RestaurantMemberService{

	@Autowired
	private RestaurantMemberDAO rdao;
	
//===============餐廳會員登入===============
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
		restaurantMemberVO = rdao.selectForLogin(restaurantMemberVO.getRestaurantAccount(), restaurantMemberVO.getRestaurantPassword());
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

	
//===============餐廳會員註冊===============
	@Override
	public RestaurantRegistVO restaurantMemberRegist(RestaurantRegistVO restaurantRegistVO) {
		if (restaurantRegistVO.getRestaurantName() == null || restaurantRegistVO.getRestaurantName().isEmpty()) {
			restaurantRegistVO.setMessage("餐廳名稱必須輸入");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		if (restaurantRegistVO.getRestaurantTel() == null || restaurantRegistVO.getRestaurantTel().isEmpty()) {
			restaurantRegistVO.setMessage("餐廳電話必須輸入");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		if (restaurantRegistVO.getRestaurantAddr() == null || restaurantRegistVO.getRestaurantAddr().isEmpty()) {
			restaurantRegistVO.setMessage("餐廳地址必須輸入");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		if (restaurantRegistVO.getRestaurantAccount()== null || restaurantRegistVO.getRestaurantAccount().isEmpty()) {
			restaurantRegistVO.setMessage("餐廳帳號信箱必須輸入");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		
		String restaurantPassString = restaurantRegistVO.getRestaurantPassword();
		if (restaurantRegistVO.getRestaurantPassword()== null || restaurantRegistVO.getRestaurantPassword().isEmpty()) {
			restaurantRegistVO.setMessage("密碼必須輸入");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		if (restaurantPassString.length() < 6 || restaurantPassString.length() > 12) {
			restaurantRegistVO.setMessage("密碼長度需介於6~25個字元");
		}
		
		//判定帳號有無重複
		if (rdao.selectByAccount(restaurantRegistVO.getRestaurantAccount()) != null) {
			restaurantRegistVO.setMessage("此帳號重複");
			restaurantRegistVO.setSuccessful(false);
			return restaurantRegistVO;
		}
		
		if (restaurantRegistVO.getMessage()!=null) {
			return restaurantRegistVO;
		}
		rdao.insert(restaurantRegistVO);
		restaurantRegistVO.setSuccessful(true);
		restaurantRegistVO.setMessage("註冊成功");
		return restaurantRegistVO;
	}

}
