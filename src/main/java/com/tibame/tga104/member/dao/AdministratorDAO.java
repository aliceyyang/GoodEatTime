package com.example.demo.tibame.dao;

import com.example.demo.tibame.vo.AdministratorVO;

public interface AdministratorDAO {
    Integer insert(AdministratorVO administratorVO);

    void update(AdministratorVO administratorVO);

    void deleteByAdminNo(Integer adminNo);

    AdministratorVO getByAdminNo(Integer adminNo);

    AdministratorVO getByAdminAccount(String adminAccount);

}
