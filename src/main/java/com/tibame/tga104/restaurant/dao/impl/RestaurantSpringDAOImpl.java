package com.tibame.tga104.restaurant.dao.impl;

import com.tibame.tga104.restaurant.dao.RestaurantSpringDAO;
import com.tibame.tga104.restaurant.dto.RestaurantRequest;
import com.tibame.tga104.restaurant.mapper.RestaurantRowMapper;
import com.tibame.tga104.restaurant.vo.RestaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestaurantSpringDAOImpl implements RestaurantSpringDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<RestaurantVO> getRestaurantByAll() {
        String sql = "select restaurantNo, restaurantAccount, restaurantName, restaurantStatus from restaurant";
        Map<String, Object> map = new HashMap<>();
        List<RestaurantVO> restaurantList = namedParameterJdbcTemplate.query(sql, map, new RestaurantRowMapper());
        if (restaurantList.size() > 0) {
            return restaurantList;
        } else {
            return null;
        }
    }

    @Override
    public RestaurantVO getRestaurantByNo(Integer restaurantNo) {
        String sql = "select restaurantNo, restaurantAccount, restaurantName, restaurantStatus from restaurant where restaurantNo = :restaurantNo";
        Map<String, Object> map = new HashMap<>();
        map.put("restaurantNo", restaurantNo);
        List<RestaurantVO> restaurantVOList = namedParameterJdbcTemplate.query(sql, map, new RestaurantRowMapper());
        if (restaurantVOList != null) {
            return restaurantVOList.get(0);
        } else {
            return null;
        }


    }

    @Override
    public void updateRestaurantByNo(Integer restaurantNo, RestaurantRequest restaurantRequest) {
        String sql = "update restaurant set restaurantStatus = :restaurantStatus where restaurantNo = :restaurantNo";
        Map<String, Object> map = new HashMap<>();
        map.put("restaurantStatus", restaurantRequest.getRestaurantStatus());
        map.put("restaurantNo", restaurantNo);
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
    }
}
