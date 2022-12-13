package com.tibame.tga104.order.service;


import com.tibame.tga104.order.vo.AdOrder;

import java.util.List;

public interface AdOrderService {
    Integer createAdOrder(AdOrder adOrder);

    void updateAdOrder(Integer adOrderVO, AdOrder adOrder);

    void deleteByAdOrderNo(Integer adOrderNo);

    AdOrder getByAdOrderNo(Integer adOrderNo);

    AdOrder getByRestaurantNo(Integer restaurantNo);

    List<AdOrder> getByAll();;
}
