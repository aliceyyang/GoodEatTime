package com.tibame.tga104.member.service;

import com.tibame.tga104.member.vo.Administrator;

import java.util.List;

public interface AdministratorService {
    Integer insert(Administrator administrator);

    void update(Administrator administrator);

    void deleteByAdminNo(Integer adminNo);

    Administrator getByAdminNo(Integer adminNo);

    Administrator getByAdminAccount(String adminAccount);


    List<Administrator> getByAll();
}
