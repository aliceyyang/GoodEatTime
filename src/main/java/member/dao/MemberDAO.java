package member.dao;

import member.vo.Member;

public interface MemberDAO {
	
	Member selectByMemberNo(Integer memberNo);
	
	int insert(Member member);
	
	int updateByMemberId(Member member);
}
