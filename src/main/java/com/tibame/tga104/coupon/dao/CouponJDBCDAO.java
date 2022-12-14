package com.tibame.tga104.coupon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.coupon.vo.CouponVO;

public class CouponJDBCDAO implements CouponDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/GoodEatTime?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT = 
			"insert into coupon values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		private static final String GET_ALL = 
				"select * from coupon";
		private static final String GET_ONE = 
				"select * from coupon where couponNo = ?";
		private static final String DELETE = 
				"delete from coupon where couponNo = ?";
		private static final String UPDATE = 
				"update coupon set restaurantNo=?,adminNo=?,couponApplyDate=?,couponName=?,"
			  + "couponStartTime=?,couponEndTime=?,verified=?,couponContent=?,usageLimitation=?,"
			  + "amountOrFold=?,couponType=?,maxIssueQty=?,issuedQty=?,verificationDetail=?";
		@Override
		public void insert(CouponVO couponVO) {
			Connection con  = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,userid,passwd);
				ps = con.prepareStatement(INSERT);
				
				ps.setInt(1, couponVO.getRestaurantNo());
				ps.setInt(2, couponVO.getAdminNo());
				ps.setTimestamp(3, couponVO.getCouponApplyDate());
				ps.setString(4, couponVO.getCouponName());
				ps.setTimestamp(5, couponVO.getCouponStartTime());
				ps.setTimestamp(6, couponVO.getCouponEndTime());
				ps.setBoolean(7, couponVO.getVerified());
				ps.setString(8, couponVO.getCouponContent());
				ps.setInt(9, couponVO.getUsageLimitation());
				ps.setDouble(10, couponVO.getAmountOrFold());
				ps.setBoolean(11, couponVO.getCouponType());
				ps.setInt(12, couponVO.getMaxIssueQty());
				ps.setInt(13, couponVO.getIssuedQty());
				ps.setString(14, couponVO.getVerificationDetail());
				
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
				if(ps != null)
					try {
						ps.close();
					} catch(Exception e) {
						e.printStackTrace(System.err);
					}
				 if(con != null) {
					 try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				 }
			}
		}

		@Override
		public void update(CouponVO couponVO) {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,userid,passwd);
				ps = con.prepareStatement(UPDATE);
				
				ps.setInt(1, couponVO.getRestaurantNo());
				ps.setInt(2, couponVO.getAdminNo());
				ps.setTimestamp(3, couponVO.getCouponApplyDate());
				ps.setString(4, couponVO.getCouponName());
				ps.setTimestamp(5, couponVO.getCouponStartTime());
				ps.setTimestamp(6, couponVO.getCouponEndTime());
				ps.setBoolean(7, couponVO.getVerified());
				ps.setString(8, couponVO.getCouponContent());
				ps.setInt(9, couponVO.getUsageLimitation());
				ps.setDouble(10, couponVO.getAmountOrFold());
				ps.setBoolean(11, couponVO.getCouponType());
				ps.setInt(12, couponVO.getMaxIssueQty());
				ps.setInt(13, couponVO.getIssuedQty());
				ps.setString(14, couponVO.getVerificationDetail());
				
				ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+e.getMessage());
			} catch(SQLException se) {
				throw new RuntimeException("A database error occured. "
						+se.getMessage());
			} finally {
				if(ps != null) {
				try {
					ps.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
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
		@Override
		public void delete(Integer couponNo) {

				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url,userid,passwd);
					ps = con.prepareStatement(DELETE);
					
					ps.setInt(1, couponNo);
					
					ps.executeUpdate();
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't loada database driver. "
							+ e.getMessage());
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
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
		}

		@Override
		public CouponVO findByPrimaryKey(Integer couponNo) {
			
			CouponVO couponVO = null;
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,userid,passwd);
				ps = con.prepareStatement(GET_ONE);
				
				ps.setInt(1, couponNo);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					couponVO = new CouponVO();
					couponVO.setCouponNo(rs.getInt("couponNo"));
					couponVO.setRestaurantNo(rs.getInt("restaurantNo"));
					couponVO.setAdminNo(rs.getInt("adminNo"));
					couponVO.setCouponApplyDate(rs.getTimestamp("couponApplyDate"));
					couponVO.setCouponName(rs.getString("couponName"));
					couponVO.setCouponStartTime(rs.getTimestamp("couponStartTime"));
					couponVO.setCouponEndTime(rs.getTimestamp("couponEndTime"));
					couponVO.setVerified(rs.getBoolean("verified"));
					couponVO.setCouponContent(rs.getString("couponContent"));
					couponVO.setUsageLimitation(rs.getInt("usageLimitation"));
					couponVO.setAmountOrFold(rs.getDouble("amountOrFold"));
					couponVO.setCouponType(rs.getBoolean("couponType"));
					couponVO.setMaxIssueQty(rs.getInt("maxIssueQty"));
					couponVO.setIssuedQty(rs.getInt("issuedQty"));
					couponVO.setVerificationDetail(rs.getString("verificationDetail"));
				}
				
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database drive. "
						+ e.getMessage());
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
				con = DriverManager.getConnection(url,userid,passwd);
				ps = con.prepareStatement(GET_ALL);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					couponVO = new CouponVO();
					couponVO.setCouponNo(rs.getInt("couponNo"));
					couponVO.setRestaurantNo(rs.getInt("restaurantNo"));
					couponVO.setAdminNo(rs.getInt("adminNo"));
					couponVO.setCouponApplyDate(rs.getTimestamp("couponApplyDate"));
					couponVO.setCouponName(rs.getString("couponName"));
					couponVO.setCouponStartTime(rs.getTimestamp("couponStartTime"));
					couponVO.setCouponEndTime(rs.getTimestamp("couponEndTime"));
					couponVO.setVerified(rs.getBoolean("verified"));
					couponVO.setCouponContent(rs.getString("couponContent"));
					couponVO.setUsageLimitation(rs.getInt("usageLimitation"));
					couponVO.setAmountOrFold(rs.getDouble("amountOrFold"));
					couponVO.setCouponType(rs.getBoolean("couponType"));
					couponVO.setMaxIssueQty(rs.getInt("maxIssueQty"));
					couponVO.setIssuedQty(rs.getInt("issuedQty"));
					couponVO.setVerificationDetail(rs.getString("verificationDetail"));
					list.add(couponVO);
				}
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't loaad database deriver. "
						+e.getMessage());
			} catch(SQLException se) {
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
				if (ps != null) {
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

}
