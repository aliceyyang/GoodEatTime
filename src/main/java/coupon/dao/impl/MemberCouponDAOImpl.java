package coupon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import coupon.dao.MemberCouponDAO;
import coupon.vo.MemberCouponVO;

public class MemberCouponDAOImpl implements MemberCouponDAO{
	private DataSource ds = null;
	
	public MemberCouponDAOImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = 
			"insert into membercoupon values(?,?,?)";
	private static final String UPDATE = 
			"update memberCoupon set memberNo = ?, couponNo = ? usageStatus = ?";
	private static final String DELETE = 
			"delete from membercoupon where memberNo = ?";
	private static final String GET_ONE =
			"select * from memberCoupon where memberNo = ?";
	private static final String GET_ALL = 
			"select * from memberCoupon";

	@Override
	public void insert(MemberCouponVO memberCouponVO) {
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT)) {
			
			ps.setInt(1, memberCouponVO.getMemberNo());
			ps.setInt(2, memberCouponVO.getCouponNo());
			ps.setBoolean(3, memberCouponVO.getUsageStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void update(MemberCouponVO memberCouponVO) {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE)){
			
			ps.setInt(1, memberCouponVO.getMemberNo());
			ps.setInt(2, memberCouponVO.getCouponNo());
			ps.setBoolean(3, memberCouponVO.getUsageStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(Integer memberNo) {
		try (Connection con = ds.getConnection();
				PreparedStatement ps =con.prepareStatement(DELETE)){
			
			ps.setInt(1, memberNo);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public MemberCouponVO findByPrimaryKey(Integer memberNo) {
		MemberCouponVO vo = null;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ONE);
						ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) {
				vo = new MemberCouponVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setCouponNo(rs.getInt(2));
				vo.setUsageStatus(rs.getBoolean(3));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<MemberCouponVO> getAll() {
		List<MemberCouponVO> list = new ArrayList<>();
		MemberCouponVO vo = null;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ALL);
				ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) {
				vo = new MemberCouponVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setCouponNo(rs.getInt(2));
				vo.setUsageStatus(rs.getBoolean(3));
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
