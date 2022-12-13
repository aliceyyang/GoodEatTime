package com.tibame.tga104.member.service;

import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface MemberService {

    List<MemberVO> getAccountByAll();
}
