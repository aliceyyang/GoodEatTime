package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.restaurant.dao.LikedRestaurantDAO;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

public class LikedRestaurantDAOImpl implements LikedRestaurantDAO{
	

	@Override
	public boolean insert(LikedRestaurantVO likedRestaurantVO) {
		int rowCount = 0;
		String insert = "insert into likedRestaurant "
				+ "values(?,?)";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(insert)){
			
			ps.setInt(1,likedRestaurantVO.getMemberNo());
			ps.setInt(2,likedRestaurantVO.getRestaurantNo());
			
			rowCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	
	@Override
	public boolean delete(Integer memberNo,Integer restaurantNo) {
		int rowCount = 0;
		String delete = "delete from likedRestaurant "
				+ "where memberNo = ? and restaurantNo = ?";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(delete)){
			
			ps.setInt(1,memberNo);
			ps.setInt(2,restaurantNo);
			rowCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public List<LikedRestaurantVO> findByMemberNo(Integer memberNo) {
		String findByMemberNo = "select * from likedRestaurant "
				+ "where memberNo = ?;";
		
		List<LikedRestaurantVO> list = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(findByMemberNo);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				LikedRestaurantVO vo = new LikedRestaurantVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
