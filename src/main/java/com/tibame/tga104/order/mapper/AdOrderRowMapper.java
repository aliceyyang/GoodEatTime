package com.tibame.tga104.order.mapper;


import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdOrderRowMapper implements RowMapper<AdOrder> {

    @Override
    public AdOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdOrder adOrder = new AdOrder();
        adOrder.setAdOrderNo(rs.getInt("adOrderNo"));
        adOrder.setRestaurantNo(rs.getInt("restaurantNo"));
        adOrder.setAdminNo(rs.getInt("adminNo"));
        adOrder.setAdOrderTime(rs.getTimestamp("adOrderTime"));
        adOrder.setAdStartTime(rs.getTimestamp("adStartTime"));
        adOrder.setAdEndTime(rs.getTimestamp("adEndTime"));
        adOrder.setVerified(rs.getBoolean("verified"));
        adOrder.setVerificationDetail(rs.getString("verificationDetail"));
        adOrder.setAdOrderPrice(rs.getInt("adOrderPrice"));
        adOrder.setSlideshowPic(rs.getBytes("slideshowPic"));

        return adOrder;
    }
}
