package com.tibame.tga104.order.dao;


import com.tibame.tga104.order.vo.AdOrderVO;

public interface AdOrderDAO {
    Integer insert(AdOrderVO adOrderVO);

    void update(AdOrderVO adOrderVO);

    void deleteByAdOrderNo(Integer adOrderNo);

    AdOrderVO getByAdOrderNo(Integer adOrderNo);

    AdOrderVO getByRestaurantNo(Integer restaurantNo);
}
