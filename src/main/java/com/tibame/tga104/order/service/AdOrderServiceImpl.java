package com.tibame.tga104.order.service;

import com.tibame.tga104.order.dao.AdOrderDAO;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdOrderServiceImpl implements AdOrderService {
    @Autowired
    private AdOrderDAO adOrderDAO;

    @Override
    public Integer createAdOrder(AdOrder adOrder) {
        return adOrderDAO.createAdOrder(adOrder);
    }

    @Override
    public void updateAdOrder(Integer adOrderNo, AdOrder adOrder) {
        adOrderDAO.updateAdOrder(adOrderNo, adOrder);
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
}
