package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.MenuDAO;
import com.tibame.tga104.restaurant.vo.MenuVO;

@Repository
public class MenuDAOImpl implements MenuDAO{
	

	@Override
	public boolean insert(MenuVO menuVO) {
		String insert = "insert into menu(restaurantNo,menuPic,menuPicRemark) "
				+ "values(?,?,?)";
		int rowCount = 0;
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(insert)){
			
			ps.setInt(1,menuVO.getRestaurantNo());
			ps.setBytes(2,menuVO.getMenuPic());
			ps.setString(3,menuVO.getMenuPicRemark());

			
			rowCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	
	}

//	==================以下待補上===================
	
	@Override
	public boolean update(MenuVO menuVO) {
		String update = "update menu "
				+ "set menuPic = ?,menuPicRemark = ? "
				+ "where menuNo = ?";
		return false;
	}

	@Override
	public boolean delete(Integer menuNo) {
		String delete = "delete from menu "
				+ "where menuNo = ?";
		return false;
	}

	@Override
	public List<MenuVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from menu "
				+ "where restaurantNo = ?";
		return null;
	}

}
