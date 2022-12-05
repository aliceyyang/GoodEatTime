package com.tibame.tga104.membercoupon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tibame.tga104.membercoupon.dao.MemberCouponDAO;
import com.tibame.tga104.membercoupon.vo.MemberCouponVO;

public class MemberCouponImpl implements MemberCouponDAO{
	private DataSource ds = null;
	
	public MemberCouponImpl() {
		try {
			ds =(DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String GET_ALL = 
			"select * from memberCoupon";
	private static final String GET_ONE = 
			"select * from memberCoupon where memberNo = ?";
	private static final String INSERT = 
			"insert into memberCoupon values(?,?,?)";
	private static final String DELETE = 
			"delete from memberCoupon where memberNo = ?";
	private static final String UPDATE = 
			"update memberCoupon set memberNo = ?, couponNo = ?, usageStatus = ?";
	@Override
	public void insert(MemberCouponVO membercouponVO) {
			try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT)) {
				
				ps.setInt(1, membercouponVO.getMemberNo());
				ps.setInt(2, membercouponVO.getCouponNo());
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void update(MemberCouponVO membercoponVO) {
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE)) {
			
			ps.setInt(1, membercoponVO.getMemberNo());
			ps.setInt(2, membercoponVO.getCouponNo());
			ps.setBoolean(3, membercoponVO.getUsageStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer memberNo) {
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE)) {
			
			ps.setInt(1, memberNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberCouponVO findByPrimaryKey(Integer MemberNo) {
		MemberCouponVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE);
			
			ps.setInt(1, MemberNo);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				vo = new MemberCouponVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setCouponNo(rs.getInt(2));
				vo.setUsageStatus(rs.getBoolean(3));
				
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(ps != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return vo;
	}

	@Override
	public List<MemberCouponVO> getAll() {
		List<MemberCouponVO> list = new ArrayList<>();
		MemberCouponVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				vo  = new MemberCouponVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setCouponNo(rs.getInt(2));
				vo.setUsageStatus(rs.getBoolean(3));
				
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}
