package com.tibame.tga104.member.dao.impl;

import com.tibame.tga104.member.dao.MemberSpringDAO;
import com.tibame.tga104.member.mapper.MemberRowMapper;
import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemberSpringDAOImpl implements MemberSpringDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<MemberVO> getAccountByAll() {
        String sql = "select memberNo, mail, name, memberLevel, verificationAccount from member";
        Map<String, Object> map = new HashMap<>();
        List<MemberVO> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());
        if (memberList.size() > 0) {
            return memberList;
        } else {
            return null;
        }

    }
}
