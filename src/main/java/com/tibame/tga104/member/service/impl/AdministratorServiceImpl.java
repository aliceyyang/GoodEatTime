package com.example.demo.tibame.service;

import com.example.demo.tibame.dao.AdministratorDAO;
import com.example.demo.tibame.vo.AdministratorVO;
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
