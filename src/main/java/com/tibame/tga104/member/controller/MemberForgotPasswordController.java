package com.tibame.tga104.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

public class MemberForgotPasswordController {
	
	@Autowired
	private MemberService service;
	
	//先拿到會員mail帳號
	@PostMapping("/forgetpassword")
	public MemberVO forgetpassword(@RequestBody MemberVO memberVO) {
	//判定此mail是不是會員
		if (memberVO == null) {
			memberVO = new MemberVO();
			//不是會員
			memberVO.setMessage("密碼已寄到您的信箱");
			//資安問題，不管是不是會員都要回密碼已寄到您信箱
			memberVO.setSuccessful(false);
		}else {
			memberVO.setSuccessful(true);
			memberVO.setMessage("密碼已寄到您的信箱");
		}
		return memberVO;
	}
	
	
	
	
	
	//然後要寄信唷哈哈哈哈哈哈我不會哈哈哈哈哈哈
	
	//拿到密碼後導向登入頁面
	
//	@PostMapping("/forgotPassword")
//	public MemberVO forgotPassword(@RequestBody MemberVO memberVO) {
//		memberVO = service.forgotPassWord(memberVO);
//		
//		return null;
//		
//	}
	
	
}
