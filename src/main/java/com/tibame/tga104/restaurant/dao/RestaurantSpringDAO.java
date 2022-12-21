package com.tibame.tga104.restaurant.dao;

import com.tibame.tga104.restaurant.dto.RestaurantRequest;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

import java.util.List;

public interface RestaurantSpringDAO {

    List<RestaurantVO> getRestaurantByAll();

    RestaurantVO getRestaurantByNo(Integer restaurantNo);

    void updateRestaurantByNo(Integer restaurantNo, RestaurantRequest restaurantRequest);
}
