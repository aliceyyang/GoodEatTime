package com.tibame.tga104.member.dao;

import java.util.List;

import com.tibame.tga104.member.vo.MemberVO;


public interface MemberDAO {
	
	
//會員登入
//	public abstract List<MemberVO> selectForLogin(String mail, String memberPassword);
	public abstract MemberVO selectForLogin(String mail, String memberPassword);

	MemberVO selectBymail(String mail);
	
//會員註冊	
	public abstract MemberVO insert(MemberVO member);
	public String verificationCode(String mail);
	public String getCode(String mail);
	
//修改會員資料	
	public abstract MemberVO selectByMemberNo(Integer memberNo);
	public abstract int update(MemberVO member);
	
	
	
}
