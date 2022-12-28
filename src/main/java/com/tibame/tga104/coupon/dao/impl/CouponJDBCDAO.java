package com.tibame.tga104.coupon.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.coupon.dao.CouponDao;
import com.tibame.tga104.coupon.vo.CouponVO;

public class CouponJDBCDAO implements CouponDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/GoodEatTime?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT = "insert into coupon"
			+ "(adminNo,restaurantNo,couponName,couponStartTime,couponEndTime, usageLimitation,"
			+ "amountOrFold, couponType, maxIssueQty, couponContent)" + "values(?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL = "select * from coupon";
	private static final String GET_ONE = "select * from coupon where couponNo = ?";
	private static final String DELETE = "delete from coupon where couponNo = ?";
	private static final String UPDATE = "update coupon set restaurantNo=?,adminNo=?,couponApplyDate=?,couponName=?,"
			+ "couponStartTime=?,couponEndTime=?,verified=?,couponContent=?,usageLimitation=?,"
			+ "amountOrFold=?,couponType=?,maxIssueQty=?,issuedQty=?,verificationDetail=?, couponPic=?";
	private static final String SetVerified = "update coupon set verified = ? whete couponNo = ?";
	private static final String SetCouponType = "update coupon set couponType = ? where couponNo = ?";

	private static final String SetmaxIssueQty = "update coupon set maxIssueQty = ? where couponNo = ?";

	@Override
	public CouponVO insert(CouponVO couponVO) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(INSERT);

			ps.setInt(1, couponVO.getAdminNo());
			ps.setInt(2, couponVO.getRestaurantNo());
			ps.setString(3, couponVO.getCouponName());
			ps.setDate(4, couponVO.getCouponStartTime());
			ps.setDate(5, couponVO.getCouponEndTime());
			ps.setInt(6, couponVO.getUsageLimitation());
			ps.setDouble(7, couponVO.getAmountOrFold());
			ps.setInt(8, couponVO.getMaxIssueQty());
			ps.setString(9, couponVO.getCouponContent());
			ps.setBytes(10, couponVO.getCouponPic());

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return couponVO;
	}

	@Override
	public void delete(Integer couponNo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(DELETE);

			ps.setInt(1, couponNo);

			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't loada database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (ps != null) {
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
	}

	@Override
	public CouponVO findByPrimaryKey(Integer couponNo) {

		CouponVO couponVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ONE);

			ps.setInt(1, couponNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				couponVO = new CouponVO();
				couponVO.setCouponNo(rs.getInt("couponNo"));
				couponVO.setRestaurantNo(rs.getInt("restaurantNo"));
				couponVO.setAdminNo(rs.getInt("adminNo"));
				couponVO.setCouponApplyDate(rs.getTimestamp("couponApplyDate"));
				couponVO.setCouponName(rs.getString("couponName"));
				couponVO.setCouponStartTime(rs.getDate("couponStartTime"));
				couponVO.setCouponEndTime(rs.getDate("couponEndTime"));
				couponVO.setVerified(rs.getBoolean("verified"));
				couponVO.setCouponContent(rs.getString("couponContent"));
				couponVO.setUsageLimitation(rs.getInt("usageLimitation"));
				couponVO.setAmountOrFold(rs.getDouble("amountOrFold"));
				couponVO.setCouponType(rs.getBoolean("couponType"));
				couponVO.setMaxIssueQty(rs.getInt("maxIssueQty"));
				couponVO.setIssuedQty(rs.getInt("issuedQty"));
				couponVO.setVerificationDetail(rs.getString("verificationDetail"));
				couponVO.setCouponPic(rs.getBytes("couponPic"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database drive. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (ps != null) {
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
		return couponVO;
	}

	@Override
	public List<CouponVO> getAll() {
		List<CouponVO> list = new ArrayList<CouponVO>();
		CouponVO couponVO = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();

			while (rs.next()) {
				couponVO = new CouponVO();
				couponVO.setCouponNo(rs.getInt("couponNo"));
				couponVO.setRestaurantNo(rs.getInt("restaurantNo"));
				couponVO.setAdminNo(rs.getInt("adminNo"));
				couponVO.setCouponApplyDate(rs.getTimestamp("couponApplyDate"));
				couponVO.setCouponName(rs.getString("couponName"));
				couponVO.setCouponStartTime(rs.getDate("couponStartTime"));
				couponVO.setCouponEndTime(rs.getDate("couponEndTime"));
				couponVO.setVerified(rs.getBoolean("verified"));
				couponVO.setCouponContent(rs.getString("couponContent"));
				couponVO.setUsageLimitation(rs.getInt("usageLimitation"));
				couponVO.setAmountOrFold(rs.getDouble("amountOrFold"));
				couponVO.setCouponType(rs.getBoolean("couponType"));
				couponVO.setMaxIssueQty(rs.getInt("maxIssueQty"));
				couponVO.setIssuedQty(rs.getInt("issuedQty"));
				couponVO.setVerificationDetail(rs.getString("verificationDetail"));
				couponVO.setCouponPic(rs.getBytes("couponPic"));
				list.add(couponVO);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't loaad database deriver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (ps != null) {
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

	@Override
	public void updateByCouponNo(CouponVO couponVO) {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement ps = con.prepareStatement(
						"update coupon set " + "couponName = ?," + "couponStartTime = ?," + "couponEndTime = ?,"
								+ "couponContent = ?," + "amountOrFold = ?," + "couponType = ?," + "maxIssueQty = ?,"
								+ "couponPic = ?," + "usageLimitation = ? " + "where couponNo = ?")) {

			ps.setString(1, couponVO.getCouponName());
			ps.setDate(2, couponVO.getCouponStartTime());
			ps.setDate(3, couponVO.getCouponEndTime());
			ps.setString(4, couponVO.getCouponContent());
			ps.setDouble(5, couponVO.getAmountOrFold());
			ps.setBoolean(6, couponVO.getCouponType());
			ps.setInt(7, couponVO.getMaxIssueQty());
			ps.setBytes(8, couponVO.getCouponPic());
			ps.setInt(9, couponVO.getUsageLimitation());
			ps.setInt(10, couponVO.getCouponNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CouponVO> selectByRestaurantNo(Integer restaurantNo) {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement ps = con
						.prepareStatement("SELECT * FROM GoodEatTime.coupon where restaurantNo = ?")) {
			ps.setInt(1, restaurantNo);

			try (ResultSet rs = ps.executeQuery()) {
				List<CouponVO> list = new ArrayList<CouponVO>();
				while (rs.next()) {
					CouponVO vo = new CouponVO();

					vo.setCouponNo(rs.getInt("couponNo"));
					vo.setRestaurantNo(rs.getInt("restaurantNo"));
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

	@Override
	public CouponVO insertByRestaurantNo(Integer restaurantNo) {
		CouponVO vo = new CouponVO();

		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement ps = con.prepareStatement(INSERT)) {

			ps.setString(1, vo.getCouponName());
			ps.setDate(2, vo.getCouponStartTime());
			ps.setDate(3, vo.getCouponEndTime());
			ps.setInt(4, vo.getUsageLimitation());
			ps.setDouble(5, vo.getAmountOrFold());
			ps.setInt(6, vo.getMaxIssueQty());
			ps.setString(7, vo.getCouponContent());
			ps.setBytes(8, vo.getCouponPic());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<CouponVO> getAllCouponPic() {
		try (Connection con = DriverManager.getConnection(url,userid,passwd);
				PreparedStatement ps = con.prepareStatement("SELECT couponPic FROM GoodEatTime.coupon;")) {

			try (ResultSet rs = ps.executeQuery()) {
				List<CouponVO> list = new ArrayList<CouponVO>();
				while (rs.next()) {
					CouponVO vo = new CouponVO();
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