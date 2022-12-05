package com.tibame.tga104.common.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tibame.tga104.restaurant.vo.RestaurantVO;

public class ConnectionTest_JDBC {
	private static String URL = "jdbc:mysql://localhost:3306/Goodeattime?serverTimezone=Asia/Taipei";
	private static String USER = "root";
	private static String PASSWORD = "password";
	
	public static void main(String[] args) {
		RestaurantVO vo = null;
		
		String sql = "select * from restaurant where restaurantNo = ?";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				vo = new RestaurantVO();
				
				vo.setRestaurantNo(rs.getInt(1));
				vo.setRestaurantTel(rs.getString(2));
				vo.setRestaurantName(rs.getString(3));
				vo.setRestaurantTaxIDNo(rs.getString(4));
				vo.setRestaurantAccountInfo(rs.getString(5));
				vo.setRestaurantBusinessHour(rs.getString(6));
				vo.setRestaurantAddr(rs.getString(7));
				vo.setRestaurantStatus(rs.getBoolean(8));
				vo.setRestaurantAccount(rs.getString(9));
				vo.setRestaurantPassword(rs.getString(10));
				vo.setRestaurantCommentQuantity(rs.getInt(11));
				vo.setTotalCommentRating(rs.getInt(12));
			}
			
			System.out.println(vo.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
