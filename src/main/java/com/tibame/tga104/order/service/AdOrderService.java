package com.tibame.tga104.order.service;


import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface AdOrderService {
    Integer createAdOrder(AdOrderRequest adOrderRequest);

    void updateAdOrder(Integer adOrderNo, AdOrderRequest adOrderRequest);

    void deleteByAdOrderNo(Integer adOrderNo);

    AdOrder getByAdOrderNo(Integer adOrderNo);

    AdOrder getByRestaurantNo(Integer restaurantNo);

    List<AdOrder> getByAll();;
}
