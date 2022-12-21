package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.RestaurantPostDAO;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;


@Repository
public class RestaurantPostDAOImpl implements RestaurantPostDAO {

	@Override
	public boolean insert(RestaurantPostVO restaurantPostVO) {
		String insert = "insert into restaurantPost(restaurantNo,postType,postPic,postTitle,postContent) "
				+ "values(?,?,?,?,?)";
		int rowCount = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(insert)) {

			ps.setInt(1, restaurantPostVO.getRestaurantNo());
			ps.setString(2, restaurantPostVO.getPostType());
			ps.setBytes(3, restaurantPostVO.getPostPic());
			ps.setString(4, restaurantPostVO.getPostTitle());
			ps.setString(5, restaurantPostVO.getPostContent());

			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public boolean update(RestaurantPostVO restaurantPostVO) {
		int rowCount = 0;
		String update = "update restaurantPost "
				+ "set postType = ?,postPic = ?,postTitle = ?,postContent = ? "
				+ "where restaurantPostNo = ?";
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(update)){
				
				ps.setString(1,restaurantPostVO.getPostType());
				ps.setBytes(2,restaurantPostVO.getPostPic());
				ps.setString(3,restaurantPostVO.getPostTitle());
				ps.setString(4,restaurantPostVO.getPostContent());
				ps.setInt(5,restaurantPostVO.getRestaurantPostNo());
				
				rowCount = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rowCount != 0;
	}

	@Override
	public boolean delete(Integer restaurantPostNo) {
		int rowCount = 0;
		String delete = "delete from restaurantPost "
				+ "where restaurantPostNO = ?";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(delete)){
				
				ps.setInt(1,restaurantPostNo);
				rowCount = ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rowCount != 0;
	}

	@Override
	public List<RestaurantPostVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from restaurantPost " + "where restaurantNO = ?";
		List<RestaurantPostVO> list = new ArrayList<RestaurantPostVO>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(findByRestaurantNo);) {
			ps.setInt(1, restaurantNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RestaurantPostVO vo = new RestaurantPostVO();
				vo.setRestaurantPostNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setPostType(rs.getString(3));
				vo.setPostPic(rs.getBytes(4));
				vo.setPostTitle(rs.getString(5));
				vo.setPostContent(rs.getString(6));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
