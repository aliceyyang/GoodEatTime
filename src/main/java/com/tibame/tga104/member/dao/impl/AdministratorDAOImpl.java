package com.tibame.tga104.member.dao.impl;

import com.tibame.tga104.member.dao.AdministratorDAO;
import com.tibame.tga104.member.mapper.AdministratorRowMapper;
import com.tibame.tga104.member.vo.Administrator;
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
    public Integer insert(Administrator administrator) {
        String sql = "insert into administrator(adminAccount, adminPassword, adminName, modifyAdminData, modifyMemberData, verifyRestaurant, verifyAdCoupon) " +
                "values(:adminAccount, :adminPassword, :adminName, :modifyAdminData, :modifyMemberData, :verifyRestaurant, :verifyAdCoupon);";
        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", administrator.getAdminAccount());
        map.put("adminPassword", administrator.getAdminPassword());
        map.put("adminName", administrator.getAdminName());
        map.put("modifyAdminData", administrator.getModifyAdminData());
        map.put("modifyMemberData", administrator.getModifyMemberData());
        map.put("verifyRestaurant", administrator.getVerifyRestaurant());
        map.put("verifyAdCoupon", administrator.getVerifyAdCoupon());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int adminNo = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 adminNo 為" + adminNo);
        return adminNo;
    }

    @Override
    public void update(Integer adminNo, Administrator administrator) {
        String sql = "update administrator set adminAccount = :adminAccount, adminPassword = :adminPassword, adminName = :adminName, modifyAdminData = :modifyAdminData, modifyMemberData = :modifyMemberData, verifyRestaurant = :verifyRestaurant, verifyAdCoupon = :verifyAdCoupon where adminNo = :adminNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", adminNo);
        map.put("adminAccount", administrator.getAdminAccount());
        map.put("adminPassword", administrator.getAdminPassword());
        map.put("adminName", administrator.getAdminName());
        map.put("modifyAdminData", administrator.getModifyAdminData());
        map.put("modifyMemberData", administrator.getModifyMemberData());
        map.put("verifyRestaurant", administrator.getVerifyRestaurant());
        map.put("verifyAdCoupon", administrator.getVerifyAdCoupon());
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
    public Administrator getByAdminNo(Integer adminNo) {
        String sql = "select * from administrator where adminNo = :adminNo";
        Map<String, Object> map = new HashMap<>();
        map.put("adminNo", adminNo);
        List<Administrator> administratorList = namedParameterJdbcTemplate.query(sql, map, new AdministratorRowMapper());
        if (administratorList.size() > 0) {
            return administratorList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Administrator getByAdminAccount(String adminAccount) {
        String sql = "select * from administrator where adminAccount = :adminAccount";
        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        List<Administrator> administratorList = namedParameterJdbcTemplate.query(sql, map, new AdministratorRowMapper());
        if (administratorList.size() > 0) {
            return administratorList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Administrator> getByAll() {
        String sql = "select * from administrator";
        Map<String, Object> map = new HashMap<>();
        List<Administrator> administratorList = namedParameterJdbcTemplate.query(sql, map, new AdministratorRowMapper());
        if (administratorList.size() > 0) {
            return administratorList;
        } else {
            return null;
        }
    }
}
