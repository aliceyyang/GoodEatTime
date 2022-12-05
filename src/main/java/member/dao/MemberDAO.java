package member.dao;

import member.vo.Member;

public interface MemberDAO {
	
//	Member selectByMemberNo(Integer memberNo);
//	
//	int insert(Member member);
//	
//	int updateByMemberId(Member member);
	
	public abstract Member select(Integer memberNo);
	
	public abstract Member insert(Member member);
	
	public abstract Member update(String name, String memberPassword, String tel, byte[] memberPic);
	
}
