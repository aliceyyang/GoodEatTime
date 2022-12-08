package com.tibame.tga104.member.mapper;

import com.tibame.tga104.member.vo.AdministratorVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorRowMapper implements RowMapper<AdministratorVO> {
    @Override
    public AdministratorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdministratorVO administratorVO = new AdministratorVO();
        administratorVO.setAdminNo(rs.getInt("adminNo"));
        administratorVO.setAdminAccount(rs.getString("adminAccount"));
        administratorVO.setAdminPassword(rs.getString("adminPassword"));
        administratorVO.setAdminName(rs.getString("adminName"));
        administratorVO.setModifyAdminData(rs.getBoolean("modifyAdminData"));
        administratorVO.setModifyMemberData(rs.getBoolean("modifyMemberData"));
        administratorVO.setVerifyRestaurant(rs.getBoolean("verifyRestaurant"));
        administratorVO.setVerifyAdCoupon(rs.getBoolean("verifyAdCoupon"));

        return administratorVO;
    }
}
