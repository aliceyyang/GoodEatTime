package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.restaurant.dao.RestaurantPicDAO;
import com.tibame.tga104.restaurant.vo.RestaurantPicVO;

public class RestaurantPicDaoImpl implements RestaurantPicDAO{

	@Override
	public void insert(RestaurantPicVO restaurantPicVO) {
		String insert = "insert into restaurantPic(restaurantNo,restaurantPic,restaurantPicRemark)"
				+ "values(?,?,?)";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(insert)){
			
			ps.setInt(1,restaurantPicVO.getRestaurantNo());
			ps.setBytes(2, restaurantPicVO.getRestaurantPic());
			ps.setString(3,restaurantPicVO.getRestaurantPicRemark());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(RestaurantPicVO restaurantPicVO) {
		String update = "update restaurantPic"
				+ "set restaurantPic = ? ,restaurantPicRemark = ?"
				+ "where restaurantPicNo = ?;";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(update)){
				
				ps.setBytes(1,restaurantPicVO.getRestaurantPic());
				ps.setString(2,restaurantPicVO.getRestaurantPicRemark());
				ps.setInt(3,restaurantPicVO.getRestaurantPicNo());
				
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void delete(Integer restaurantPicNo) {
		String delete = "delete from restaurantPic"
				+ "where restaurantPicNo = ?";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(delete)){
				
				ps.setInt(1,restaurantPicNo);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public RestaurantPicVO findByPrimaryKey(Integer restaurantPicNo) {
		String findByPrimaryKey = "select * from restaurant where restaurantPicNo = ?";
		RestaurantPicVO vo = null;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(findByPrimaryKey);
			ResultSet rs = ps.executeQuery()){
			
			ps.setInt(1, restaurantPicNo);
			while(rs.next()) {
				vo = new RestaurantPicVO();
				
				vo.setRestaurantPicNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setRestaurantPic(rs.getBytes(3));
				vo.setRestaurantPicRemark(rs.getString(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}



	@Override
	public List<RestaurantPicVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from restaurantPic"
				+ "where restaurantNo = ?";
		
		List<RestaurantPicVO> list = new ArrayList<>();
		
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(findByRestaurantNo);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				RestaurantPicVO vo = new RestaurantPicVO();
				
				vo.setRestaurantPicNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setRestaurantPic(rs.getBytes(3));
				vo.setRestaurantPicRemark(rs.getString(4));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
