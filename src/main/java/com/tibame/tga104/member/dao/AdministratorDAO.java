package com.tibame.tga104.member.dao;

import com.tibame.tga104.member.vo.AdministratorVO;

public interface AdministratorDAO {
    Integer insert(AdministratorVO administratorVO);

    void update(AdministratorVO administratorVO);

    void deleteByAdminNo(Integer adminNo);

    AdministratorVO getByAdminNo(Integer adminNo);

    AdministratorVO getByAdminAccount(String adminAccount);

}
