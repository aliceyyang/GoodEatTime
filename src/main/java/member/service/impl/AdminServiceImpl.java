package member.service.impl;

import javax.naming.NamingException;

import member.dao.AdminDAO;
import member.dao.impl.AdminDAOImpl;

public class AdminServiceImpl implements member.service.AdminService {

	private AdminDAO dao;

	public AdminServiceImpl() throws NamingException {
		dao = new AdminDAOImpl();
	}



	@Override
	public member.vo.AdminVO login(member.vo.AdminVO adminVO) {
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




