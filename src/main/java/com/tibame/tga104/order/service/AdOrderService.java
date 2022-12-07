package com.tibame.tga104.order.service;


import com.tibame.tga104.order.vo.AdOrderVO;

public interface AdOrderService {
    Integer insert(AdOrderVO adOrderVO);

    void update(AdOrderVO adOrderVO);

    void deleteByAdOrderNo(Integer adOrderNo);

    AdOrderVO getByAdOrderNo(Integer adOrderNo);

    AdOrderVO getByRestaurantNo(Integer restaurantNo);
}
