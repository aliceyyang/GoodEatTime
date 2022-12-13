package com.tibame.tga104.member.mapper;

import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<MemberVO> {
    @Override
    public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        MemberVO member = new MemberVO();
        member.setMemberNo(rs.getInt("memberNo"));
        member.setMail(rs.getString("mail"));
        member.setName(rs.getString("name"));
        member.setMemberLevel(rs.getInt("memberLevel"));
        member.setVerificationAccount(rs.getBoolean("verificationAccount"));

        return member;
    }
}
