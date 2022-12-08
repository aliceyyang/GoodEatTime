package com.tibame.tga104.order.mapper;


import com.tibame.tga104.order.vo.AdOrderVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdOrderRowMapper implements RowMapper<AdOrderVO> {

    @Override
    public AdOrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdOrderVO adOrderVO = new AdOrderVO();
        adOrderVO.setAdOrderNo(rs.getInt("adOrderNo"));
        adOrderVO.setRestaurantNo(rs.getInt("restaurantNo"));
        adOrderVO.setAdminNo(rs.getInt("adminNo"));
        adOrderVO.setAdOrderTime(rs.getTimestamp("adOrderTime"));
        adOrderVO.setVerified(rs.getBoolean("verified"));
        adOrderVO.setVerificationDetail(rs.getString("verificationDetail"));
        adOrderVO.setAdOrderPrice(rs.getInt("adOrderPrice"));
        adOrderVO.setSlideshowPic(rs.getBytes("slideshowPic"));

        return adOrderVO;
    }
}
