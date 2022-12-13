package com.tibame.tga104.order.dao;

import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.mapper.AdOrderRowMapper;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdOrderDAOImpl implements AdOrderDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<AdOrder> getByAll() {
        String sql = "select * from adOrder";
        Map<String, Object> map = new HashMap<>();
        List<AdOrder> adOrderList = namedParameterJdbcTemplate.query(sql, map, new AdOrderRowMapper());
        if (adOrderList.size() > 0) {
            return adOrderList;
        } else {
            return null;
        }
    }

    @Override
    public Integer createAdOrder(AdOrderRequest adOrderRequest) {
        String sql = "insert into adOrder(restaurantNo, adminNo, adOrderTime, adStartTime, adEndTime, verified, " +
                "verificationDetail, adOrderPrice, slideshowPic) values(:restaurantNo, :adminNo, :adOrderTime, " +
                ":adStartTime, :adEndTime, :verified, :verificationDetail, :adOrderPrice, :slideshowPic)";
        Map<String, Object> map = new HashMap();
        map.put("restaurantNo", adOrderRequest.getRestaurantNo());
        map.put("adminNo", adOrderRequest.getAdminNo());
        map.put("adOrderTime", new Date());
        map.put("adStartTime", adOrderRequest.getAdStartTime());
        map.put("adEndTime", adOrderRequest.getAdEndTime());
        map.put("verified", adOrderRequest.getVerified());
        map.put("verificationDetail", adOrderRequest.getVerificationDetail());
        map.put("adOrderPrice", adOrderRequest.getAdOrderPrice());
        map.put("slideshowPic", adOrderRequest.getSlideshowPic());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int adOrderNo = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 adOrderNo 為" + adOrderNo);

        return adOrderNo;
    }

    @Override
    public void updateAdOrder(Integer adOrderNo, AdOrderRequest adOrderRequest) {
        String sql = "update adOrder set restaurantNo = :restaurantNo, adminNo = :adminNo, " +
                "adStartTime = :adStartTime, adEndTime = :adEndTime, verified = :verified, " +
                "verificationDetail = :verificationDetail, adOrderPrice = :adOrderPrice, slideshowPic = :slideshowPic " +
                "where adOrderNo = :adOrderNo";

        Map<String, Object> map = new HashMap<>();

        map.put("adOrderNo", adOrderNo);

        map.put("restaurantNo", adOrderRequest.getRestaurantNo());
        map.put("adminNo", adOrderRequest.getAdminNo());
        map.put("adStartTime", adOrderRequest.getAdStartTime());
        map.put("adEndTime", adOrderRequest.getAdEndTime());
        map.put("verified", adOrderRequest.getVerified());
        map.put("verificationDetail", adOrderRequest.getVerificationDetail());
        map.put("adOrderPrice", adOrderRequest.getAdOrderPrice());
        map.put("slideshowPic", adOrderRequest.getSlideshowPic());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteByAdOrderNo(Integer adOrderNo) {
        String sql = "delete from adOrder where adOrderNo = :adOrderNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adOrderNo", adOrderNo);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public AdOrder getByAdOrderNo(Integer adOrderNo) {
        String sql = "select adOrderNo, restaurantNo, adminNo, adOrderTime, adStartTime, adEndTime, verified, " +
                "verificationDetail, adOrderPrice, slideshowPic from adOrder where adOrderNo = :adOrderNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adOrderNo", adOrderNo);
        List<AdOrder> adOrderList = namedParameterJdbcTemplate.query(sql, map, new AdOrderRowMapper());
        if (adOrderList.size() > 0) {
            return adOrderList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public AdOrder getByRestaurantNo(Integer restaurantNo) {
        String sql = "select adOrderNo, restaurantNo, adminNo, adOrderTime, adStartTime, adEndTime, verified, " +
                "verificationDetail, adOrderPrice, slideshowPic from adOrder where restaurantNo = :restaurantNo";
        Map<String, Object> map = new HashMap<>();
        map.put("restaurantNo", restaurantNo);
        List<AdOrder> adOrderList = namedParameterJdbcTemplate.query(sql, map, new AdOrderRowMapper());
        if (adOrderList.size() > 0) {
            return adOrderList.get(0);
        } else {
            return null;
        }
    }



}
