package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.RestaurantCarouselPicDAO;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;

@Repository
public class RestaurantCarouselPicDAOImpl implements RestaurantCarouselPicDAO {

	@Override
	public boolean insert(RestaurantCarouselPicVO restaurantCarouselPicVO) {
		int rowCount = 0;
		String insert = "insert into restaurantCarouselPic(restaurantNo,carouselPic) "
				+ "values(?,?)";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(insert)){
			
			ps.setInt(1,restaurantCarouselPicVO.getRestaurantNo());
			ps.setBytes(2,restaurantCarouselPicVO.getCarouselPic());

			
			rowCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}
	
//	==================以下待補上===================

	@Override
	public boolean update(RestaurantCarouselPicVO restaurantCarouselPicVO) {
		String update = "update restaurantCarouselPic "
				+ "set carouselPic = ? "
				+ "where carouselPicNo = ?";
		return false;
	}

	@Override
	public boolean delete(Integer carouselPicNo) {
		String delete = "delete from restaurantCarouselPic "
				+ "where carouselPicNo = ?";
		return false;
	}

	@Override
	public List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from restaurantCarouselPic "
				+ "where restaurantNo = ?";
		return null;
	}
	

}
