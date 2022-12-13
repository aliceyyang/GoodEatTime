package com.tibame.tga104.restaurant.mapper;

import com.tibame.tga104.restaurant.vo.RestaurantVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantRowMapper implements RowMapper<RestaurantVO> {
    @Override
    public RestaurantVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        RestaurantVO restaurant = new RestaurantVO();
        restaurant.setRestaurantNo(rs.getInt("restaurantNo"));
        restaurant.setRestaurantAccount(rs.getString("restaurantAccount"));
        restaurant.setRestaurantName(rs.getString("restaurantName"));
        restaurant.setRestaurantStatus(rs.getBoolean("restaurantStatus"));

        return restaurant;
    }
}
