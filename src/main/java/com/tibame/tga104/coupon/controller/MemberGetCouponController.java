package com.tibame.tga104.coupon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.coupon.service.MemberCouponService;
import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;

@RestController
@RequestMapping("/GoodEatTime")
public class MemberGetCouponController {

	@Autowired
	public MemberCouponService memberCouponService;
		
	
	@PostMapping("/getCoupon")
	public MemberCouponVO coupon(HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		MemberCouponVO vo  = memberCouponService.addOneCoupon(memberVO.getMemberNo());
		return vo;
	}
}
