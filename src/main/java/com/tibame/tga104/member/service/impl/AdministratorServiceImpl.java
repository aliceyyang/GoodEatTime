package com.tibame.tga104.member.service.impl;

import com.tibame.tga104.member.dao.AdministratorDAO;
import com.tibame.tga104.member.service.AdministratorService;
import com.tibame.tga104.member.vo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDAO administratorDAO;

    @Override
    public Integer insert(Administrator administrator) {
        return administratorDAO.insert(administrator);
    }

    @Override
    public void update(Administrator administrator) {
        administratorDAO.update(administrator);

    }

    @Override
    public void deleteByAdminNo(Integer adminNo) {
        administratorDAO.deleteByAdminNo(adminNo);

    }

    @Override
    public Administrator getByAdminNo(Integer adminNo) {
        return administratorDAO.getByAdminNo(adminNo);
    }

    @Override
    public Administrator getByAdminAccount(String adminAccount) {
        return administratorDAO.getByAdminAccount(adminAccount);
    }

    @Override
    public List<Administrator> getByAll(){
        return administratorDAO.getByAll();
    }
}
