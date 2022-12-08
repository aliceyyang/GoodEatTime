package com.example.demo.tibame.dao;

import com.example.demo.tibame.mapper.AdministratorRowMapper;
import com.example.demo.tibame.vo.AdministratorVO;
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
public class AdministratorDAOImpl implements AdministratorDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer insert(AdministratorVO administratorVO) {
        String sql = "insert into administrator(adminAccount, adminPassword, adminName, modifyAdminData, modifyMemberData, verifyRestaurant, verifyAdCoupon) " +
                "values(:adminAccount, :adminPassword, :adminName, :modifyAdminData, :modifyMemberData, :verifyRestaurant, :verifyAdCoupon);";
        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", administratorVO.getAdminAccount());
        map.put("adminPassword", administratorVO.getAdminPassword());
        map.put("adminName", administratorVO.getAdminName());
        map.put("modifyAdminData", administratorVO.getModifyAdminData());
        map.put("modifyMemberData", administratorVO.getModifyMemberData());
        map.put("verifyRestaurant", administratorVO.getVerifyRestaurant());
        map.put("verifyAdCoupon", administratorVO.getVerifyAdCoupon());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));

        int adminNo = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 adminNo 為" + adminNo);
        return adminNo;
    }

    @Override
    public void update(AdministratorVO administratorVO) {
        String sql = "update administrator set adminAccount = :adminAccount, adminPassword = :adminPassword, adminName = :adminName, modifyAdminData = :modifyAdminData, modifyMemberData = :modifyMemberData, verifyRestaurant = :verifyRestaurant, verifyAdCoupon = :verifyAdCoupon where adminNo = :adminNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", administratorVO.getAdminNo());
        map.put("adminAccount", administratorVO.getAdminAccount());
        map.put("adminPassword", administratorVO.getAdminPassword());
        map.put("adminName", administratorVO.getAdminName());
        map.put("modifyAdminData", administratorVO.getModifyAdminData());
        map.put("modifyMemberData", administratorVO.getModifyMemberData());
        map.put("verifyRestaurant", administratorVO.getVerifyRestaurant());
        map.put("verifyAdCoupon", administratorVO.getVerifyAdCoupon());
        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteByAdminNo(Integer adminNo) {
        String sql = "delete from administrator where adminNo = :adminNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", adminNo);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public AdministratorVO getByAdminNo(Integer adminNo) {
        String sql = "select * from administrator where adminNo = :adminNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", adminNo);
        List<AdministratorVO> administratorVOList = namedParameterJdbcTemplate.query(sql, map, new AdministratorRowMapper());
        if (administratorVOList.size() > 0) {
            return administratorVOList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public AdministratorVO getByAdminAccount(String adminAccount) {
        String sql = "select * from administrator where adminAccount = :adminAccount";
        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        List<AdministratorVO> administratorVOList = namedParameterJdbcTemplate.query(sql, map, new AdministratorRowMapper());
        if (administratorVOList.size() > 0) {
            return administratorVOList.get(0);
        } else {
            return null;
        }
    }
}
