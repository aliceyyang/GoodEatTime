package com.tibame.tga104.member.dao;

import com.tibame.tga104.member.vo.MemberVO;

import java.util.List;

public interface MemberSpringDAO {
    List<MemberVO> getAccountByAll();
}
