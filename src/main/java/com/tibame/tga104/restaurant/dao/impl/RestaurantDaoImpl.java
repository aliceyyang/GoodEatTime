package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga104.restaurant.dao.RestaurantDao;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

public class RestaurantDaoImpl implements RestaurantDao {	
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/GoodEatTime";
	String username = "root";
	String password = "password";
	
	@Override
	
	public boolean insert(RestaurantVO restaurantVO) {
		int rowCount = 0;
		String insert = "insert into restaurant(restaurantTel,restaurantName,restaurantTaxIDNo,restaurantAccountInfo,restaurantBusinessHour,restaurantAddr,restaurantStatus,restaurantAccount,restaurantPassword,restaurantCommentQuantity,totalCommentRating)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?);";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(insert)) {
			
			ps.setString(1,restaurantVO.getRestaurantTel());
			ps.setString(2,restaurantVO.getRestaurantName());
			ps.setString(3,restaurantVO.getRestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getRestaurantAccountInfo());
			ps.setString(5,restaurantVO.getRestaurantBusinessHour());
			ps.setString(6,restaurantVO.getRestaurantAddr());
			ps.setBoolean(7,restaurantVO.getRestaurantStatus());
			ps.setString(8,restaurantVO.getRestaurantAccount());
			ps.setString(9,restaurantVO.getRestaurantPassword());
			ps.setInt(10,restaurantVO.getRestaurantCommentQuantity());
			ps.setInt(11,restaurantVO.getTotalCommentRating());
			
			rowCount = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public boolean update(RestaurantVO restaurantVO) {
		int rowCount = 0;
		String update = "update restaurant set restaurantTel=?,restaurantName=?,restaurantTaxIDNo=?,restaurantAccountInfo=?,restaurantBusinessHour=?,restaurantAddr=?,"
				+ "restaurantAccount=?,restaurantPassword=? where restaurantNo=?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(update)){
			
			ps.setString(1,restaurantVO.getRestaurantTel());
			ps.setString(2,restaurantVO.getRestaurantName());
			ps.setString(3,restaurantVO.getRestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getRestaurantAccountInfo());
			ps.setString(5,restaurantVO.getRestaurantBusinessHour());
			ps.setString(6,restaurantVO.getRestaurantAddr());
			ps.setString(7,restaurantVO.getRestaurantAccount());
			ps.setString(8,restaurantVO.getRestaurantPassword());
			ps.setInt(9,restaurantVO.getRestaurantNo());
			
			rowCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount != 0;
	}

	@Override
	public void setStatus(Integer restaurantNo,Boolean restaurantStatus) {
		String setStatus = "update restaurant"
				+ "set restaurantStatus = ?"
				+ "where restaurantNo = ?;";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(setStatus)){
			
			ps.setBoolean(1,restaurantStatus);
			ps.setInt(2,restaurantNo);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public RestaurantVO findByPrimaryKey(Integer restaurantNo) {
		String findByPrimaryKey = "select * from restaurant where restaurantNo = ?";
		
		RestaurantVO vo = null;
		try(
			Connection con = getConnection();
//			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(findByPrimaryKey);
			){
			
			ps.setInt(1,restaurantNo);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<RestaurantVO> getAll() {
		String getAll = "select * from restaurant";
		
		List<RestaurantVO> list = new ArrayList<>();
		try (
				Connection con = getConnection();
//				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(getAll);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				RestaurantVO vo = new RestaurantVO();
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
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		RestaurantDaoImpl test = new RestaurantDaoImpl();
//		List<RestaurantVO> list =  test.getAll();
//		for (RestaurantVO vo : list) {
//			System.out.println(vo.toString());
//		}
		RestaurantVO vo = new RestaurantVO();
		vo = test.findByPrimaryKey(1);
		System.out.println(vo.toString());
		
	}
}