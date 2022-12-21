package com.tibame.tga104.coupon.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.tibame.tga104.coupon.dao.CouponDao;
import com.tibame.tga104.coupon.vo.CouponVO;

public class CouponDaoImpl implements CouponDao {
	private DataSource ds = null;

	private static String URL = "jdbc:mysql://localhost:3306/goodeattime?serverTimezone=Asia/Taipei";
	private static String USER = "root";
	private static String PASSWORD = "password";

	private static final String GET_ALL = 
			"select * from coupon";
	private static final String GET_ONE = 
			"select * from coupon where couponNo = ?";
	private static final String INSERT = 
			"insert into coupon values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE = 
			"delete from coupon where couponNo = ?";
	private static final String UPDATE = 
			"update coupon set restaurantNo=?,adminNo=?,couponApplyDate=?,couponName=?,"
		  + "couponStartTime=?,couponEndTime=?,verified=?,couponContent=?,usageLimitation=?,"
		  + "amountOrFold=?,couponType=?,maxIssueQty=?,issuedQty=?,verificationDetail=?, couponPic = ?"
		  + "where couponNo = ?";
	private static final String setVerified = "update coupon set verified = ? where couponNo = ?";
	
	private static final String setcouponType = "update coupon set couponType = ? where couponNo = ?";
	
	private static final String setmaxIssueQty ="update coupon set maxIssueQty = ? wherer couponNo = ?";
	@Override
	public void insert(CouponVO couponVO) {
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)){
			
			ps.setInt(1, couponVO.getRestaurantNo());
			ps.setInt(2, couponVO.getAdminNo());
			ps.setTimestamp(3, couponVO.getCouponApplyDate());
			ps.setString(4, couponVO.getCouponName());
			ps.setDate(5, couponVO.getCouponStartTime());
			ps.setDate(6, couponVO.getCouponEndTime());
			ps.setBoolean(7, couponVO.getVerified());
			ps.setString(8, couponVO.getCouponContent());
			ps.setInt(9, couponVO.getUsageLimitation());
			ps.setDouble(10, couponVO.getAmountOrFold());
			ps.setBoolean(11, couponVO.getCouponType());
			ps.setInt(12, couponVO.getMaxIssueQty());
			ps.setInt(13, couponVO.getIssuedQty());
			ps.setString(14, couponVO.getVerificationDetail());
			ps.setBytes(15, couponVO.getCouponPic());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void updateByCouponNo(CouponVO couponVO) {
		try(
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement("update coupon set "
					+ "couponName = ?,"
					+ "couponStartTime = ?,"
					+ "couponEndTime = ?,"
					+ "couponContent = ?,"
					+ "amountOrFold = ?,"
					+ "couponType = ?,"
					+ "maxIssueQty = ?,"
					+ "couponPic = ?"
					+ "where couponNo = ?")) {
			
			ps.setString(1, couponVO.getCouponName());
			ps.setDate(2, couponVO.getCouponStartTime());
			ps.setDate(3, couponVO.getCouponEndTime());
			ps.setString(4, couponVO.getCouponContent());
			ps.setDouble(5, couponVO.getAmountOrFold());
			ps.setBoolean(6, couponVO.getCouponType());
			ps.setInt(7, couponVO.getMaxIssueQty());
			ps.setBytes(8, couponVO.getCouponPic());
			ps.setInt(9, couponVO.getCouponNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer couponNo) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps = con.prepareStatement(DELETE)) {
			
			ps.setInt(1, couponNo);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public CouponVO findByPrimaryKey(Integer couponNo) {
		CouponVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			ps = con.prepareStatement(GET_ONE);
			
			ps.setInt(1, couponNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new CouponVO();
				vo.setCouponNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setAdminNo(rs.getInt(3));
				vo.setCouponApplyDate(rs.getTimestamp(4));
				vo.setCouponName(rs.getString(5));
				vo.setCouponStartTime(rs.getDate(6));
				vo.setCouponEndTime(rs.getDate(7));
				vo.setVerified(rs.getBoolean(8));
				vo.setCouponContent(rs.getString(9));
				vo.setUsageLimitation(rs.getInt(10));
				vo.setAmountOrFold(rs.getDouble(11));
				vo.setCouponType(rs.getBoolean(12));
				vo.setMaxIssueQty(rs.getInt(13));
				vo.setIssuedQty(rs.getInt(14));
				vo.setVerificationDetail(rs.getString(15));
				vo.setCouponPic(rs.getBytes(16));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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
	public List<CouponVO> getAll() {
		List<CouponVO> list = new ArrayList<>();
		CouponVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new CouponVO();
				vo.setCouponNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setAdminNo(rs.getInt(3));
				vo.setCouponApplyDate(rs.getTimestamp(4));
				vo.setCouponName(rs.getString(5));
				vo.setCouponStartTime(rs.getDate(6));
				vo.setCouponEndTime(rs.getDate(7));
				vo.setVerified(rs.getBoolean(8));
				vo.setCouponContent(rs.getString(9));
				vo.setUsageLimitation(rs.getInt(10));
				vo.setAmountOrFold(rs.getDouble(11));
				vo.setCouponType(rs.getBoolean(12));
				vo.setMaxIssueQty(rs.getInt(13));
				vo.setIssuedQty(rs.getInt(14));
				vo.setVerificationDetail(rs.getString(15));
				vo.setCouponPic(rs.getBytes(15));
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
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<CouponVO> selectByRestaurantNo(Integer restaurantNo) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM GoodEatTime.coupon where restaurantNo = ?")){
				ps.setInt(1, restaurantNo);
				
				try (ResultSet rs = ps.executeQuery()) {
					List<CouponVO> list = new ArrayList<CouponVO>();
					while (rs.next()) {
						CouponVO vo = new CouponVO();
						vo.setCouponNo(rs.getInt("couponNo"));
						vo.setCouponApplyDate(rs.getTimestamp("couponApplyDate"));
						vo.setCouponStartTime(rs.getDate("couponStartTime"));
						vo.setCouponEndTime(rs.getDate("couponEndTime"));
						vo.setCouponContent(rs.getString("couponContent"));
						vo.setUsageLimitation(rs.getInt("usageLimitation"));
						vo.setAmountOrFold(rs.getDouble("amountOrFold"));
						vo.setCouponType(rs.getBoolean("couponType"));
						vo.setCouponName(rs.getString("couponName"));
						vo.setMaxIssueQty(rs.getInt("maxIssueQty"));
						vo.setIssuedQty(rs.getInt("IssuedQty"));
						vo.setVerified(rs.getBoolean("verified"));
						vo.setCouponPic(rs.getBytes("couponPic"));
						
						list.add(vo);
					}
					return list;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
