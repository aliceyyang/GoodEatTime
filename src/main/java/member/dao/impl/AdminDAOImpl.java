package member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class AdminDAOImpl implements member.dao.AdminDAO {
	private DataSource dataSource;

	public AdminDAOImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/goodeattime");
	}





@Override
public member.vo.AdminVO selectForAdminLogin(member.vo.AdminVO adminVO) {
	String sql = "Select * from administrator where adminAccount = ? and adminPassword = ?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
		pstmt.setString(1, adminVO.getAdminAccount());
		pstmt.setString(2, adminVO.getAdminPassword());
		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				member.vo.AdminVO resultadminVO = new member.vo.AdminVO();
				resultadminVO.setAdminNo(rs.getInt("adminNo"));
				resultadminVO.setAdminAccount(rs.getString("adminAccount"));
				resultadminVO.setAdminPassword(rs.getString("adminPassword"));
				resultadminVO.setAdminName(rs.getString("adminName"));
				return resultadminVO;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return null;
}
}
