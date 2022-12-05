package com.tibame.tga104.member.service.impl;

import javax.naming.NamingException;

import com.tibame.tga104.member.dao.AdminDAO;
import com.tibame.tga104.member.dao.impl.AdminDAOImpl;
import com.tibame.tga104.member.service.AdminService;
import com.tibame.tga104.member.vo.AdminVO;

public class AdminServiceImpl implements AdminService {

	private AdminDAO dao;

	public AdminServiceImpl() throws NamingException {
		dao = new AdminDAOImpl();
	}



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

		return dao.selectForAdminLogin(adminVO);
	}
	}




