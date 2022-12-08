package com.tibame.tga104.member.service.impl;

import com.tibame.tga104.member.dao.AdministratorDAO;
import com.tibame.tga104.member.service.AdministratorService;
import com.tibame.tga104.member.vo.AdministratorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDAO administratorDAO;

    @Override
    public Integer insert(AdministratorVO administratorVO) {
        return administratorDAO.insert(administratorVO);
    }

    @Override
    public void update(AdministratorVO administratorVO) {
        administratorDAO.update(administratorVO);

    }

    @Override
    public void deleteByAdminNo(Integer adminNo) {
        administratorDAO.deleteByAdminNo(adminNo);

    }

    @Override
    public AdministratorVO getByAdminNo(Integer adminNo) {
        return administratorDAO.getByAdminNo(adminNo);
    }

    @Override
    public AdministratorVO getByAdminAccount(String adminAccount) {
        return administratorDAO.getByAdminAccount(adminAccount);
    }
}
