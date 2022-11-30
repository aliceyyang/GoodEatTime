package member.dao;

import member.vo.Member;

public interface MemberDAO {
	Member selectByMemberNo(Integer memberNo);
}
