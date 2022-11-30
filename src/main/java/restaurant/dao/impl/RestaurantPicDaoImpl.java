package restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import restaurant.dao.RestaurantPicDAO;
import restaurant.vo.RestaurantPicVo;
import restaurant.vo.RestaurantVO;

import static common.util.JdbcUtil.*;

public class RestaurantPicDaoImpl implements RestaurantPicDAO{
	
	private static final String GET_ALL = "select * from restaurantPic";
	private static final String GET_ONE = "select * from restaurant where restaurantPicNo = ?";
	private static final String INSERT = "insert into restaurantPic values(?,?,?)";
	private static final String DELETE = "delete from restaurant where restaurantPicNo = ?";
	private static final String UPDATE = "update restaurant set restaurantPic=?,restaurantPicRemark=? where restaurantPicNo = ?";
	
	@Override
	public void insert(RestaurantPicVo restaurantPicVO) {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)){
			
			ps.setInt(1,restaurantPicVO.getrestaurantNo());
			ps.setBytes(2, restaurantPicVO.getrestaurantPic());
			ps.setString(3,restaurantPicVO.getrestaurantPicRemark());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(RestaurantPicVo restaurantPicVO) {
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT)){
				
				ps.setBytes(1,restaurantPicVO.getrestaurantPic());
				ps.setString(2,restaurantPicVO.getrestaurantPicRemark());
				ps.setInt(3,restaurantPicVO.getrestaurantPicNo());
				
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void delete(Integer restaurantPicNo) {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE)){
				
				ps.setInt(1,restaurantPicNo);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public RestaurantPicVo findByPrimaryKey(Integer restaurantPicNo) {
		RestaurantPicVo vo = null;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(GET_ONE);
			ResultSet rs = ps.executeQuery()){
			
			ps.setInt(1, restaurantPicNo);
			while(rs.next()) {
				vo = new RestaurantPicVo();
				
				vo.setrestaurantPicNo(rs.getInt(1));
				vo.setrestaurantNo(rs.getInt(2));
				vo.setrestaurantPic(rs.getBytes(3));
				vo.setrestaurantPicRemark(rs.getString(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<RestaurantPicVo> getAll() {
		List<RestaurantPicVo> list = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ALL);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				RestaurantPicVo vo = new RestaurantPicVo();
				
				vo.setrestaurantPicNo(rs.getInt(1));
				vo.setrestaurantNo(rs.getInt(2));
				vo.setrestaurantPic(rs.getBytes(3));
				vo.setrestaurantPicRemark(rs.getString(4));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
