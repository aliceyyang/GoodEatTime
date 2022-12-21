package com.tibame.tga104.member.dao;

import com.tibame.tga104.member.dto.MemberRequest;
import com.tibame.tga104.member.vo.MemberVO;

import java.util.List;

public interface MemberSpringDAO {

    List<MemberVO> getMemberByAll();

    MemberVO getMemberByNo(Integer memberNo);

    void updateMemberByNo(Integer memberNo, MemberRequest memberRequest);
}
