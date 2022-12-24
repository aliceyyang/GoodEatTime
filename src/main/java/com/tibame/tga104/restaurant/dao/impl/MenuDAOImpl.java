package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.MenuDAO;
import com.tibame.tga104.restaurant.vo.MenuVO;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;

@Repository
public class MenuDAOImpl implements MenuDAO {

	@Override
	public boolean insert(MenuVO menuVO) {
		String insert = "insert into menu(restaurantNo,menuPic,menuPicRemark) " + "values(?,?,?)";
		int rowCount = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(insert)) {

			ps.setInt(1, menuVO.getRestaurantNo());
			ps.setBytes(2, menuVO.getMenuPic());
			ps.setString(3, menuVO.getMenuPicRemark());

			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;

	}

	@Override
	public boolean update(MenuVO menuVO) {
		int rowCount = 0;
		String update = "update menu " + "set menuPic = ?,menuPicRemark = ? " + "where menuNo = ?";
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(update)){
				
				ps.setBytes(1,menuVO.getMenuPic());
				ps.setString(2,menuVO.getMenuPicRemark());
				ps.setInt(3,menuVO.getMenuNo());
				
				rowCount = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rowCount != 0;
	}

	@Override
	public boolean delete(Integer menuNo) {
		String delete = "delete from menu " + "where menuNo = ?";
		int rowCount = 0;

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(delete)) {

			ps.setInt(1, menuNo);
			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public List<MenuVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select * from menu " + "where restaurantNo = ?";
		List<MenuVO> list = new ArrayList<MenuVO>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(findByRestaurantNo);) {
			ps.setInt(1, restaurantNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setMenuNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				vo.setMenuPic(rs.getBytes(3));
				vo.setMenuPicRemark(rs.getString(4));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
