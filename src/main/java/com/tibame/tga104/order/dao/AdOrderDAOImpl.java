package com.tibame.tga104.order.dao;

import com.tibame.tga104.order.mapper.AdOrderRowMapper;
import com.tibame.tga104.order.vo.AdOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdOrderDAOImpl implements AdOrderDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer insert(AdOrderVO adOrderVO) {
        String sql = "insert into adOrder(restaurantNo, adminNo, adOrderTime, adStartTime, adEndTime, verified, verificationDetail, adOrderPrice, slideshowPic) " +
                "values(:restaurantNo, :adminNo, :adOrderTime, :adStartTime, :adEndTime, :verified, :verificationDetail, :adOrderPrice, :slideshowPic)";
        Map<String, Object> map = new HashMap();
        map.put("restaurantNo", adOrderVO.getRestaurantNo());
        map.put("adminNo", adOrderVO.getAdminNo());
        map.put("adOrderTime", adOrderVO.getAdOrderTime());
        map.put("adStartTime", adOrderVO.getAdStartTime());
        map.put("adEndTime", adOrderVO.getAdEndTime());
        map.put("verified", adOrderVO.getVerified());
        map.put("verificationDetail", adOrderVO.getVerificationDetail());
        map.put("adOrderPrice", adOrderVO.getAdOrderPrice());
        map.put("slideshowPic", adOrderVO.getSlideshowPic());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));

        int adOrderNo = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 adOrderNo 為" + adOrderNo);

        return adOrderNo;
    }

    @Override
    public void update(AdOrderVO adOrderVO) {
        String sql = "update adOrder set restaurantNo = :restaurantNo, adminNo = :adminNo, adStartTime = :adStartTime, adEndTime = :adEndTime, verified = :verified, verificationDetail = :verificationDetail, adOrderPrice = :adOrderPrice, slideshowPic = :slideshowPic where adOrderNo = :adOrderNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adOrderNo", adOrderVO.getAdOrderNo());
        map.put("restaurantNo", adOrderVO.getRestaurantNo());
        map.put("adminNo", adOrderVO.getAdminNo());
        map.put("adOrderTime", adOrderVO.getAdOrderTime());
//        map.put("adStartTime", adOrderVO.getAdStartTime());
        map.put("adEndTime", adOrderVO.getAdEndTime());
        map.put("verified", adOrderVO.getVerified());
        map.put("verificationDetail", adOrderVO.getVerificationDetail());
        map.put("adOrderPrice", adOrderVO.getAdOrderPrice());
        map.put("slideshowPic", adOrderVO.getSlideshowPic());

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
    public AdOrderVO getByAdOrderNo(Integer adOrderNo) {
        String sql = "select * from adOrder where adOrderNo = :adOrderNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adOrderNo", adOrderNo);
        List<AdOrderVO> adOrderVOList = namedParameterJdbcTemplate.query(sql, map, new AdOrderRowMapper());
        if (adOrderVOList.size() > 0) {
            return adOrderVOList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public AdOrderVO getByRestaurantNo(Integer restaurantNo) {
        String sql = "select * from adOrder where restaurantNo = :restaurantNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adOrderNo", restaurantNo);
        List<AdOrderVO> adOrderVOList = namedParameterJdbcTemplate.query(sql, map, new AdOrderRowMapper());
        if (adOrderVOList.size() > 0) {
            return adOrderVOList.get(0);
        } else {
            return null;
        }
    }


}
