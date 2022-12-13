package com.tibame.tga104.order.service;

import com.tibame.tga104.order.dao.AdOrderDAO;
import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdOrderServiceImpl implements AdOrderService {
    @Autowired
    private AdOrderDAO adOrderDAO;

    @Override
    public Integer createAdOrder(AdOrderRequest adOrderRequest) {
        return adOrderDAO.createAdOrder(adOrderRequest);
    }

    @Override
    public void updateAdOrder(Integer adOrderNo, AdOrderRequest adOrderRequest) {
        adOrderDAO.updateAdOrder(adOrderNo, adOrderRequest);
    }

    @Override
    public void deleteByAdOrderNo(Integer adOrderNo) {
        adOrderDAO.deleteByAdOrderNo(adOrderNo);
    }

    @Override
    public AdOrder getByAdOrderNo(Integer adOrderNo) {
        return adOrderDAO.getByAdOrderNo(adOrderNo);
    }

    @Override
    public AdOrder getByRestaurantNo(Integer restaurantNo) {
        return adOrderDAO.getByRestaurantNo(restaurantNo);
    }

    @Override
    public List<AdOrder> getByAll() {
        return adOrderDAO.getByAll();
    }
}
