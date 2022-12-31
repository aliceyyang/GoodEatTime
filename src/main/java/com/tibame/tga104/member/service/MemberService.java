package com.tibame.tga104.member.service;

import com.tibame.tga104.member.vo.MemberVO;

public interface MemberService {

	MemberVO register(MemberVO memberVO);
	
	MemberVO memberLogin(MemberVO memberVO);
	
	MemberVO findMemberByNo(MemberVO memberVO);
	
	MemberVO edit(MemberVO memberVO);
	
	boolean save(MemberVO memberVO);
	
	MemberVO forgotPassWord(MemberVO memberVO);
	
	
		
}
