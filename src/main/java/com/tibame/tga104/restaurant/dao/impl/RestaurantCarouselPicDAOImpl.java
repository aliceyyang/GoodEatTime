package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.RestaurantCarouselPicDAO;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;


@Repository
public class RestaurantCarouselPicDAOImpl implements RestaurantCarouselPicDAO {

	@Override
	public boolean insert(RestaurantCarouselPicVO restaurantCarouselPicVO) {
		int rowCount = 0;
		String insert = "insert into restaurantCarouselPic(restaurantNo,carouselPic) " + "values(?,?)";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(insert)) {

			ps.setInt(1, restaurantCarouselPicVO.getRestaurantNo());
			ps.setBytes(2, restaurantCarouselPicVO.getCarouselPic());

			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public boolean delete(Integer carouselPicNo) {
		int rowCount = 0;
		String delete = "delete from restaurantCarouselPic " + "where carouselPicNo = ?";
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(delete)){
				
				ps.setInt(1,carouselPicNo);
				rowCount = ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rowCount != 0;
	}

	@Override
	public List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from restaurantCarouselPic " + "where restaurantNo = ?";
		List<RestaurantCarouselPicVO> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(findByRestaurantNo);) {
			ps.setInt(1, restaurantNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RestaurantCarouselPicVO vo = new RestaurantCarouselPicVO();
				vo.setCarouselPicNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setCarouselPic(rs.getBytes(3));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
