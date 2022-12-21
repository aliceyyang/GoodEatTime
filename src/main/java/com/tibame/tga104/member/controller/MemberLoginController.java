package com.tibame.tga104.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

@RestController // Controller + ResponseBody
@RequestMapping("member")
public class MemberLoginController {
	@Autowired
	private MemberService service;

	@PostMapping("login")
	public MemberVO memberlogin(@RequestBody MemberVO memberVO, HttpServletRequest req, HttpSession session) {
		if (memberVO == null) {
			memberVO = new MemberVO();
			memberVO.setMessage("查無會員資訊");
			return memberVO;
		}
		memberVO = service.memberLogin(memberVO);
		if (memberVO != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId(); // 產生一個新的id,把當前會員登入的資料塞到會員中
			}
			session = req.getSession();
			session.setAttribute("memberVO", memberVO);
		}
		return memberVO;

//		session.setAttribute(mail, mail);
//		session.setAttribute(memberPassword, memberPassword);

//		MemberVO = service.memberlogin(,);
//		

//		memberVO.setMail(mail);
//		memberVO.setMemberPassword(memberPassword);
//		if(mail == null||memberPassword == null) {
//			memberVO.setMessage("帳號密碼錯誤");
//		}
//		return memberVO;

//		

	}

}
