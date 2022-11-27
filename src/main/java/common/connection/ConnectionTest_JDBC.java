package common.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.vo.RestaurantVO;

public class ConnectionTest_JDBC {
	private static String URL = "jdbc:mysql://localhost:3306/goodeattime?serverTimezone=Asia/Taipei";
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
			
			System.out.println(vo.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
