package com.tibame.tga104.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

@RestController
@RequestMapping("member")
public class MemberForgotPasswordController {
	
	@Autowired
	private MemberService service;
	
	//先拿到會員mail帳號
	@PostMapping("/forgotpassword")
	public MemberVO forgetpassword(@RequestBody MemberVO memberVO) {
	//判定此mail是不是會員
		if (memberVO == null) {
			memberVO = new MemberVO();
		} else {
			service.forgotPassWord(memberVO);
		}
		//資安問題，不管是不是會員都要回密碼已寄到您信箱
		memberVO.setMessage("密碼已寄到您的信箱");
		memberVO.setSuccessful(true);
		return memberVO;
	}
}
