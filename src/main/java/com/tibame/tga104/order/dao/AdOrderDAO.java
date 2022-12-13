package com.tibame.tga104.order.dao;


import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.vo.AdOrder;

import java.util.List;

public interface AdOrderDAO {
    Integer createAdOrder(AdOrderRequest adOrderRequest);

    void updateAdOrder(Integer adOrderNo, AdOrderRequest adOrderRequest);

    void deleteByAdOrderNo(Integer adOrderNo);

    AdOrder getByAdOrderNo(Integer adOrderNo);

    AdOrder getByRestaurantNo(Integer restaurantNo);

    List<AdOrder> getByAll();
}
