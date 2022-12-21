package com.tibame.tga104.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.member.dao.AdminDAO;
import com.tibame.tga104.member.service.AdminService;
import com.tibame.tga104.member.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO dao;

	@Override
	public AdminVO login(AdminVO adminVO) {
		final String adminAccount = adminVO.getAdminAccount();
		final String adminPassword = adminVO.getAdminPassword();

		if (adminAccount.length() < 5 || adminAccount.length() > 50) {
			return null;
		}

		if (adminPassword.length() < 6 || adminPassword.length() > 12) {
			return null;
		}

//		if (adminAccount == null || Objects.equals(adminAccount , "")) {
//			return "帳號必須輸入";
//		}
//		if (adminPassword == null || Objects.equals(adminPassword , "")) {
//			return "密碼必須輸入";
//		}
//		

		return dao.selectForAdminLogin(adminVO);
	}
}
