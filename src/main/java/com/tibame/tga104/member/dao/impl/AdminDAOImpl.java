package com.tibame.tga104.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.member.dao.AdminDAO;
import com.tibame.tga104.member.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private DataSource dataSource;

	@Override
	public AdminVO selectForAdminLogin(AdminVO adminVO) {
		String sql = "Select * from administrator where adminAccount = ? and adminPassword = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
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
