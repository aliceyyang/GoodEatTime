package coupon.dao.impl;

import java.util.*;
import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import coupon.dao.CouponDao;
import coupon.vo.CouponVO;

public class CouponDaoImpl implements CouponDao {
	private DataSource ds = null;

	public CouponDaoImpl()  {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String GET_ALL = 
			"select * from coupon";
	private static final String GET_ONE = 
			"select * from coupon where couponNo = ?";
	private static final String INSERT = 
			"insert into coupon values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE = 
			"delete from coupon where couponNo = ?";
	private static final String UPDATE = 
			"updatte coupon set restaurantNo=?,adminNo=?,couponApplyDate=?,couponName=?,"
		  + "couponStartTime=?,couponEndTime=?,verified=?,couponContent=?,usageLimitation=?,"
		  + "amountOrFold=?,couponType=?,maxIssueQty=?,issuedQty=?,verificationDetail=?";

	@Override
	public void insert(CouponVO couponVO) {
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)){
			
			ps.setInt(1, couponVO.getRestaurantNo());
			ps.setInt(2, couponVO.getAdminNo());
			ps.setString(3, couponVO.getCouponApplyDate());
			ps.setString(4, couponVO.getCouponName());
			ps.setString(5, couponVO.getCouponStartTime());
			ps.setString(6, couponVO.getCouponEndTime());
			ps.setBoolean(7, couponVO.getVerified());
			ps.setString(8, couponVO.getCouponContent());
			ps.setInt(9, couponVO.getUsageLimitation());
			ps.setDouble(10, couponVO.getAmountOrFold());
			ps.setBoolean(11, couponVO.getCouponType());
			ps.setInt(12, couponVO.getMaxIssueQty());
			ps.setInt(13, couponVO.getIssuedQty());
			ps.setString(14, couponVO.getVerificationDetail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void update(CouponVO couponVO) {
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE)	) {
			
			ps.setInt(1, couponVO.getRestaurantNo());
			ps.setInt(2, couponVO.getAdminNo());
			ps.setString(3, couponVO.getCouponApplyDate());
			ps.setString(4, couponVO.getCouponName());
			ps.setString(5, couponVO.getCouponStartTime());
			ps.setString(6, couponVO.getCouponEndTime());
			ps.setBoolean(7, couponVO.getVerified());
			ps.setString(8, couponVO.getCouponContent());
			ps.setInt(9, couponVO.getUsageLimitation());
			ps.setDouble(10, couponVO.getAmountOrFold());
			ps.setBoolean(11, couponVO.getCouponType());
			ps.setInt(12, couponVO.getMaxIssueQty());
			ps.setInt(13, couponVO.getIssuedQty());
			ps.setString(14, couponVO.getVerificationDetail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer couponNo) {
		try(Connection con = ds.getConnection();
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
			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE);
			
			ps.setInt(1, couponNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new CouponVO();
				vo.setCouponNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setAdminNo(rs.getInt(3));
				vo.setCouponApplyDate(rs.getString(4));
				vo.setCouponName(rs.getString(5));
				vo.setCouponStartTime(rs.getString(6));
				vo.setCouponEndTime(rs.getString(7));
				vo.setVerified(rs.getBoolean(8));
				vo.setCouponContent(rs.getString(9));
				vo.setUsageLimitation(rs.getInt(10));
				vo.setAmountOrFold(rs.getDouble(11));
				vo.setCouponType(rs.getBoolean(12));
				vo.setMaxIssueQty(rs.getInt(13));
				vo.setIssuedQty(rs.getInt(14));
				vo.setVerificationDetail(rs.getString(15));
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
	public List<CouponVO> getALL() {
		List<CouponVO> list = new ArrayList<>();
		CouponVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new CouponVO();
				vo.setCouponNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setAdminNo(rs.getInt(3));
				vo.setCouponApplyDate(rs.getString(4));
				vo.setCouponName(rs.getString(5));
				vo.setCouponStartTime(rs.getString(6));
				vo.setCouponEndTime(rs.getString(7));
				vo.setVerified(rs.getBoolean(8));
				vo.setCouponContent(rs.getString(9));
				vo.setUsageLimitation(rs.getInt(10));
				vo.setAmountOrFold(rs.getDouble(11));
				vo.setCouponType(rs.getBoolean(12));
				vo.setMaxIssueQty(rs.getInt(13));
				vo.setIssuedQty(rs.getInt(14));
				vo.setVerificationDetail(rs.getString(15));
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
}
