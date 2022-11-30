package restaurant.dao.impl;

import static common.util.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import restaurant.dao.RestaurantDao;
import restaurant.vo.RestaurantVO;

public class RestaurantDaoImpl implements RestaurantDao {
	
	private static final String GET_ALL = "select * from restaurant";
	private static final String GET_ONE = "select * from restaurant where restaurantNo = ?";
	private static final String INSERT = "insert into restaurant values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE = "delete from restaurant where restaurantNo = ?";
	private static final String UPDATE = "update restaurant set restaurantTel=?,restaurantName=?,restaurantTaxIDNo=?,restaurantAccountInfo=?,restaurantBusinessHour=?,restaurantAddr=?,"
			+ "restaurantStatus=?,restaurantAccount=?,restaurantPassword=?,restaurantCommentQuantity=?,totalCommentRating=? where restaurantNo=?";
	
	
	@Override
	
	public void insert(RestaurantVO restaurantVO) {
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)) {
			
			ps.setString(1,restaurantVO.getrestaurantTel());
			ps.setString(2,restaurantVO.getrestaurantName());
			ps.setString(3,restaurantVO.getrestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getrestaurantAccountInfo());
			ps.setString(5,restaurantVO.getrestaurantBusinessHour());
			ps.setString(6,restaurantVO.getrestaurantAddr());
			ps.setBoolean(7,restaurantVO.getrestaurantStatus());
			ps.setString(8,restaurantVO.getrestaurantAccount());
			ps.setString(9,restaurantVO.getrestaurantPassword());
			ps.setInt(10,restaurantVO.getrestaurantCommentQuantity());
			ps.setInt(11,restaurantVO.getTotalCommentRating());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(RestaurantVO restaurantVO) {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE)){
			
			ps.setString(1,restaurantVO.getrestaurantTel());
			ps.setString(2,restaurantVO.getrestaurantName());
			ps.setString(3,restaurantVO.getrestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getrestaurantAccountInfo());
			ps.setString(5,restaurantVO.getrestaurantBusinessHour());
			ps.setString(6,restaurantVO.getrestaurantAddr());
			ps.setBoolean(7,restaurantVO.getrestaurantStatus());
			ps.setString(8,restaurantVO.getrestaurantAccount());
			ps.setString(9,restaurantVO.getrestaurantPassword());
			ps.setInt(10,restaurantVO.getrestaurantCommentQuantity());
			ps.setInt(11,restaurantVO.getTotalCommentRating());
			ps.setInt(12,restaurantVO.getrestaurantNo());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer restaurantNo) {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE)){
			
			ps.setInt(1,restaurantNo);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public RestaurantVO findByPrimaryKey(Integer restaurantNo) {
		RestaurantVO vo = null;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(GET_ONE);
			ResultSet rs = ps.executeQuery()){
			
			ps.setInt(1,restaurantNo);
			while(rs.next()){
				vo = new RestaurantVO();
				
				vo.setrestaurantNo(rs.getInt(1));
				vo.setrestaurantTel(rs.getString(2));
				vo.setrestaurantName(rs.getString(3));
				vo.setrestaurantTaxIDNo(rs.getString(4));
				vo.setrestaurantAccountInfo(rs.getString(5));
				vo.setrestaurantBusinessHour(rs.getString(6));
				vo.setrestaurantAddr(rs.getString(7));
				vo.setrestaurantStatus(rs.getBoolean(8));
				vo.setrestaurantAccount(rs.getString(9));
				vo.setrestaurantPassword(rs.getString(10));
				vo.setrestaurantCommentQuantity(rs.getInt(11));
				vo.setTotalCommentRating(rs.getInt(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<RestaurantVO> getAll() {
		List<RestaurantVO> list = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ALL);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				RestaurantVO vo = new RestaurantVO();
				vo.setrestaurantNo(rs.getInt(1));
				vo.setrestaurantTel(rs.getString(2));
				vo.setrestaurantName(rs.getString(3));
				vo.setrestaurantTaxIDNo(rs.getString(4));
				vo.setrestaurantAccountInfo(rs.getString(5));
				vo.setrestaurantBusinessHour(rs.getString(6));
				vo.setrestaurantAddr(rs.getString(7));
				vo.setrestaurantStatus(rs.getBoolean(8));
				vo.setrestaurantAccount(rs.getString(9));
				vo.setrestaurantPassword(rs.getString(10));
				vo.setrestaurantCommentQuantity(rs.getInt(11));
				vo.setTotalCommentRating(rs.getInt(12));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}