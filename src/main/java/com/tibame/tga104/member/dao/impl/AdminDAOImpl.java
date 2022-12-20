package com.tibame.tga104.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tibame.tga104.member.dao.AdminDAO;
import com.tibame.tga104.member.vo.AdminVO;



public class AdminDAOImpl implements AdminDAO {
	private DataSource dataSource;

	public AdminDAOImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/goodeattime");
	}


@Override
public AdminVO selectForAdminLogin(AdminVO adminVO) {
	String sql = "Select * from administrator where adminAccount = ? and adminPassword = ?";
	try (Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);) {
		pstmt.setString(1, adminVO.getAdminAccount());
		pstmt.setString(2, adminVO.getAdminPassword());
		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				AdminVO resultadminVO = new AdminVO();
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
