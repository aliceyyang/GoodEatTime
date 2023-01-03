package com.tibame.tga104.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

@RestController
public class MemberRegistController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/register")
	public MemberVO register(@RequestBody MemberVO memberVO) {
		if (memberVO == null) {
			memberVO = new MemberVO();
			memberVO.setSuccessful(false);
			memberVO.setMessage("註冊失敗");
			return memberVO;
		} else {
			String code = memberService.getVerificationCode(memberVO.getMail());
			if(memberVO.getVerificationCode().equals(code)) {
				return memberService.register(memberVO);
			}else {
				memberVO = new MemberVO();
				memberVO.setSuccessful(false);
				memberVO.setMessage("註冊失敗");
				return memberVO;
			}
		}
	}
	
	@PostMapping("/confirm")
	public boolean verify(@RequestBody MemberVO memberVO) {
		if(memberVO != null) {
			memberService.sendVerificationCode(memberVO.getMail());
			return true;
		}
		return false;
	}

}

//import java.io.IOException;
//
//import javax.naming.NamingException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.tibame.tga104.member.service.MemberService;
//import com.tibame.tga104.member.service.impl.MemberServiceImpl;
//import com.tibame.tga104.member.vo.MemberVO;
//
//@WebServlet("/MemberRegist")
//public class MemberRegistController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private MemberService service; 
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		try {
//			service = new MemberServiceImpl();
//		} catch (Exception e) {
//		}
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Gson gson = new Gson();
//		JsonObject responseObj = new JsonObject();
//		try {
//			MemberVO memberVO = gson.fromJson(request.getReader(), MemberVO.class);
//			MemberService service = new MemberServiceImpl(null);
//			final String errMsg = service.register(memberVO);
//			responseObj.addProperty("errMsg", errMsg);
//		}catch (Exception e) {
//			e.printStackTrace();
//			responseObj.addProperty("errMsg", "母丟啦");
//		}	
//		response.getWriter().append(gson.toJson(responseObj));
//	
//		
//	}
//
//}
