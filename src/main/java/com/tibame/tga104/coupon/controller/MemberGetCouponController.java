package com.tibame.tga104.coupon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.core.vo.Message;
import com.tibame.tga104.coupon.service.MemberCouponService;
import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;

@RestController
@RequestMapping("/coupon_member")
public class MemberGetCouponController {

	@Autowired
	public MemberCouponService memberCouponService;
		
	
	@PostMapping("/getCoupon")
	public Message coupon(HttpSession session, @RequestBody MemberCouponVO memberCouponVO) {
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		if (memberVO != null) {
		MemberCouponVO vo = memberCouponService.addOneCoupon(memberVO.getMemberNo(), memberCouponVO.getCouponNo());
		Message message = new Message();
		message.setSuccessful(vo != null);
		return message;
		}
		return null;
	}
}
