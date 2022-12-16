package com.tibame.tga104.common.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.tga104.restaurant.vo.RestaurantVO;


//@WebServlet("/ConnectionTest_JNDI")
public class ConnectionTest_JNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConnectionTest_JNDI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RestaurantVO vo = null;
		
		String sql = "select * from restaurant where restaurantNo = ?";
		
		try(Connection con = ServiceLocator.getInstance().getDataSource().getConnection();
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
