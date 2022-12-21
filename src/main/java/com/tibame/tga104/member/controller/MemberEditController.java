package com.tibame.tga104.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

@RestController
@RequestMapping("member")
public class MemberEditController {
	@Autowired
	private MemberService memberService;

//會員資料
	@GetMapping("/info")
	public MemberVO info(@SessionAttribute(required = false) MemberVO memberVO) {
		// 從seesion看當前會員
		if (memberVO == null) {
			memberVO = new MemberVO();
			memberVO.setMessage("查無會員資訊");
			memberVO.setSuccessful(false);
		} else {
			memberVO.setSuccessful(true);
		}
		return memberVO;
	}

//會員資料修改	
	@PostMapping("/edit")
	public MemberVO edit(
		@RequestBody MemberVO reqMember,
		//reqMember是前端來的資料
		@SessionAttribute(name = "memberVO", required = false) MemberVO seMember
	) {//seMember是session的
		reqMember.setMemberNo(seMember.getMemberNo());
		final boolean result = memberService.save(reqMember);
		reqMember.setSuccessful(result);
		if (!result) {
			reqMember.setMessage("存檔失敗!");
		}
		return reqMember;
	}
}
