package com.tibame.tga104.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.service.RestaurantMemberService;
import com.tibame.tga104.member.vo.RestaurantMemberVO;

@RestController
@RequestMapping("restaurant")
public class RestaurantMemberLoginController {
	@Autowired
	private RestaurantMemberService service;
	
	@PostMapping("login")
	public RestaurantMemberVO restaurantlogin(@RequestBody RestaurantMemberVO restaurantMemberVO, HttpServletRequest req, HttpSession session) {
		if (restaurantMemberVO == null) {
			restaurantMemberVO = new RestaurantMemberVO();
			restaurantMemberVO.setMessage("查無會員資訊");
			return restaurantMemberVO;
		}
		restaurantMemberVO = service.restaurantMemberLogin(restaurantMemberVO);
		if (restaurantMemberVO != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			session = req.getSession();
			session.setAttribute("restaurantMemberVO", restaurantMemberVO);
		}
		System.out.println(restaurantMemberVO);
		return restaurantMemberVO;
		
	}

}
