package com.tibame.tga104.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.tibame.tga104.core.vo.Message;

@RestController
@RequestMapping("member")
public class MemberLogoutController {

	@GetMapping("logout")
	protected Message memberlogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();//session完整了也就是結束了
		Message respBody = new Message();
		respBody.setSuccessful(true);
		respBody.setMessage("登出成功");
		return respBody;
	}
}
