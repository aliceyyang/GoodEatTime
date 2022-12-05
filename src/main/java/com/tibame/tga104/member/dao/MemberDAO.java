package com.tibame.tga104.member.dao;

import com.tibame.tga104.member.vo.MemberVO;

public interface MemberDAO {
	
//	Member selectByMemberNo(Integer memberNo);
//	
//	int insert(Member member);
//	
//	int updateByMemberId(Member member);
	
	public abstract MemberVO select(Integer memberNo);
	
	public abstract MemberVO insert(MemberVO member);
	
	public abstract MemberVO update(MemberVO member);
	
}
