package com.tibame.tga104.membercoupon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.membercoupon.vo.MemberCouponVO;

public class MemberCouponJDBC implements MemberCouponDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/GoodEatTime?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT = "insert into memberCoupon vlaues(?,?,?)";
	private static final String GET_ALL = "select * from memberCoupon";
	private static final String GET_ONE = "select * from memberCoupon where memberNo = ?";
	private static final String DELETE = "delete from memberCoupon where memberNo = ?";
	private static final String UPDATE = "update memberCoupon set memberNo = ?, couponNo = ?, usageStatus = ?";

	@Override
	public void insert(MemberCouponVO membercouponVO) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(INSERT);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(INSERT);

			ps.setInt(1, membercouponVO.getMemberNo());
			ps.setInt(2, membercouponVO.getCouponNo());
			ps.setBoolean(3, membercouponVO.getUsageStatus());

			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (ps != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
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
	public void update(MemberCouponVO membercoponVO) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(UPDATE);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(UPDATE);

			ps.setInt(1, membercoponVO.getMemberNo());
			ps.setInt(2, membercoponVO.getCouponNo());
			ps.setBoolean(3, membercoponVO.getUsageStatus());

			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void delete(Integer memberNo) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(DELETE);
			
			ps.setInt(1, memberNo);
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace(System.err);
					}
				}
			}
		}
	}

	@Override
	public MemberCouponVO findByPrimaryKey(Integer memberNo) {
		MemberCouponVO memberCouponVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con  = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ONE);
			
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				memberCouponVO = new MemberCouponVO();
				memberCouponVO.setMemberNo(rs.getInt("memberNo"));
				memberCouponVO.setCouponNo(rs.getInt("couponNo"));
				memberCouponVO.setUsageStatus(rs.getBoolean("usageStatus"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load databases driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace(System.err);
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
		return memberCouponVO;
	}

	@Override
	public List<MemberCouponVO> getAll() {
		List<MemberCouponVO> list = new ArrayList<MemberCouponVO>();
		MemberCouponVO membercouponVO = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				membercouponVO = new MemberCouponVO();
				membercouponVO.setMemberNo(rs.getInt("memberNo"));
				membercouponVO.setCouponNo(rs.getInt("couponNo"));
				membercouponVO.setUsageStatus(rs.getBoolean("usageStatus"));
				
				list.add(membercouponVO);
				
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occued. "
					+ se.getMessage());
		} finally {
			 if(ps != null) {
				 try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			 }
			 if(ps != null) {
				 try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
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
