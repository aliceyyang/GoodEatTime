package com.tibame.tga104.member.dao;

import java.util.List;

import com.tibame.tga104.member.vo.MemberVO;


public interface MemberDAO {
	
//	Member selectByMemberNo(Integer memberNo);
//	
//	int insert(Member member);
//	
//	int updateByMemberId(Member member);
	
	public abstract MemberVO select(Integer memberNo);
	
//會員登入
//	public abstract List<MemberVO> selectForLogin(String mail, String memberPassword);
	public abstract MemberVO selectForLogin(String mail, String memberPassword);
	
//會員註冊	
	public abstract MemberVO insert(MemberVO member);
	
	public abstract MemberVO update(MemberVO member);
	
	
	
}
