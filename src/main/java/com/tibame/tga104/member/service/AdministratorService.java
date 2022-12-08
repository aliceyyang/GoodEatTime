package com.tibame.tga104.member.service;

import com.tibame.tga104.member.vo.AdministratorVO;

public interface AdministratorService {
    Integer insert(AdministratorVO administratorVO);

    void update(AdministratorVO administratorVO);

    void deleteByAdminNo(Integer adminNo);

    AdministratorVO getByAdminNo(Integer adminNo);

    AdministratorVO getByAdminAccount(String adminAccount);

}
