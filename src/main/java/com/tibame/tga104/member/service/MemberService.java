package com.tibame.tga104.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.member.vo.MemberVO;

public interface MemberService {

	MemberVO register(MemberVO memberVO);
	
	MemberVO memberLogin(MemberVO memberVO);
		
}
