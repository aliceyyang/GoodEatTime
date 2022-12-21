package com.tibame.tga104.order.service;

import com.tibame.tga104.order.dao.AdOrderDAO;
import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.vo.AdOrder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class AdOrderServiceImpl implements AdOrderService {
    @Autowired
    private AdOrderDAO adOrderDAO;

    @Override
    public Integer createAdOrder(AdOrderRequest adOrderRequest) {
        if (adOrderRequest.getSlideshowPicBase64() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return adOrderDAO.createAdOrder(adOrderRequest);
        }
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
    public List<AdOrder> getByRestaurantNo(Integer restaurantNo) {
        return adOrderDAO.getByRestaurantNo(restaurantNo);
    }

    @Override
    public List<AdOrder> getByAll() {
        var data = adOrderDAO.getByAll();

//        for (AdOrder adOrder : data) {
//            if(adOrder.getSlideshowPic() !=null){
//                String baseStr = Base64.encodeBase64String(adOrder.getSlideshowPic());
//                adOrder.setSlideshowPicStr(baseStr);
//            }
//        }

        return data;
    }
}
