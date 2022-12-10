package com.tibame.tga104.member.mapper;

import com.tibame.tga104.member.vo.Administrator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorRowMapper implements RowMapper<Administrator> {
    @Override
    public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
        Administrator administrator = new Administrator();
        administrator.setAdminNo(rs.getInt("adminNo"));
        administrator.setAdminAccount(rs.getString("adminAccount"));
        administrator.setAdminPassword(rs.getString("adminPassword"));
        administrator.setAdminName(rs.getString("adminName"));
        administrator.setModifyAdminData(rs.getBoolean("modifyAdminData"));
        administrator.setModifyMemberData(rs.getBoolean("modifyMemberData"));
        administrator.setVerifyRestaurant(rs.getBoolean("verifyRestaurant"));
        administrator.setVerifyAdCoupon(rs.getBoolean("verifyAdCoupon"));

        return administrator;
    }
}
