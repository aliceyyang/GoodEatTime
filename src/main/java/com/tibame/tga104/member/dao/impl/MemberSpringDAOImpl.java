package com.tibame.tga104.member.dao.impl;

import com.tibame.tga104.member.dao.MemberSpringDAO;
import com.tibame.tga104.member.dto.MemberRequest;
import com.tibame.tga104.member.mapper.MemberRowMapper;
import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
    public List<MemberVO> getMemberByAll() {
        String sql = "select memberNo, mail, `name`, memberLevel, verificationAccount from member";
        Map<String, Object> map = new HashMap<>();
        List<MemberVO> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());
        if (memberList.size() > 0) {
            return memberList;
        } else {
            return null;
        }

    }

    @Override
    public MemberVO getMemberByNo(Integer memberNo) {
        String sql = "select memberNo, mail, `name`, memberLevel, verificationAccount from member where memberNo = :memberNo";
        Map<String, Object> map = new HashMap<>();
        map.put("memberNo", memberNo);
        List<MemberVO> memberVOList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());
        if (memberVOList != null) {
            return memberVOList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void updateMemberByNo(Integer memberNo, MemberRequest memberRequest) {
        String sql ="update member set memberLevel = :memberLevel, verificationAccount = :verificationAccount where memberNo = :memberNo";
        Map<String, Object> map = new HashMap<>();
        map.put("memberLevel", memberRequest.getMemberLevel());
        map.put("verificationAccount", memberRequest.getVerificationAccount());
        map.put("memberNo", memberNo);
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
    }
}
