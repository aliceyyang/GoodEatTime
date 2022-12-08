package com.tibame.tga104.order.service;

import com.tibame.tga104.order.dao.AdOrderDAO;
import com.tibame.tga104.order.vo.AdOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdOrderServiceImpl implements AdOrderService{
    @Autowired
    private AdOrderDAO adOrderDAO;

    @Override
    public Integer insert(AdOrderVO adOrderVO) {
        return adOrderDAO.insert(adOrderVO);
    }

    @Override
    public void update(AdOrderVO adOrderVO) {
        adOrderDAO.update(adOrderVO);
    }

    @Override
    public void deleteByAdOrderNo(Integer adOrderNo) {
    adOrderDAO.deleteByAdOrderNo(adOrderNo);
    }

    @Override
    public AdOrderVO getByAdOrderNo(Integer adOrderNo) {
        return adOrderDAO.getByAdOrderNo(adOrderNo);
    }

    @Override
    public AdOrderVO getByRestaurantNo(Integer restaurantNo) {
        return adOrderDAO.getByRestaurantNo(restaurantNo);
    }
}
