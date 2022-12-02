package restaurant.dao.impl;

import static common.util.JdbcUtil.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import restaurant.dao.RestaurantDao;
import restaurant.vo.RestaurantVO;

public class RestaurantDaoImpl implements RestaurantDao {	
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/GoodEatTime";
	String username = "root";
	String password = "password";
	
	@Override
	
	public void insert(RestaurantVO restaurantVO) {
		String insert = "insert into restaurant(restaurantTel,restaurantName,restaurantTaxIDNo,restaurantAccountInfo,restaurantBusinessHour,restaurantAddr,restaurantStatus,restaurantAccount,restaurantPassword,restaurantCommentQuantity,totalCommentRating)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?);";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(insert)) {
			
			ps.setString(1,restaurantVO.getrestaurantTel());
			ps.setString(2,restaurantVO.getrestaurantName());
			ps.setString(3,restaurantVO.getrestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getrestaurantAccountInfo());
			ps.setString(5,restaurantVO.getrestaurantBusinessHour());
			ps.setString(6,restaurantVO.getrestaurantAddr());
			ps.setBoolean(7,restaurantVO.getrestaurantStatus());
			ps.setString(8,restaurantVO.getrestaurantAccount());
			ps.setString(9,restaurantVO.getrestaurantPassword());
			ps.setInt(10,restaurantVO.getrestaurantCommentQuantity());
			ps.setInt(11,restaurantVO.getTotalCommentRating());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(RestaurantVO restaurantVO) {
		String update = "update restaurant set restaurantTel=?,restaurantName=?,restaurantTaxIDNo=?,restaurantAccountInfo=?,restaurantBusinessHour=?,restaurantAddr=?,"
				+ "restaurantAccount=?,restaurantPassword=? where restaurantNo=?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(update)){
			
			ps.setString(1,restaurantVO.getrestaurantTel());
			ps.setString(2,restaurantVO.getrestaurantName());
			ps.setString(3,restaurantVO.getrestaurantTaxIDNo());
			ps.setString(4,restaurantVO.getrestaurantAccountInfo());
			ps.setString(5,restaurantVO.getrestaurantBusinessHour());
			ps.setString(6,restaurantVO.getrestaurantAddr());
			ps.setString(7,restaurantVO.getrestaurantAccount());
			ps.setString(8,restaurantVO.getrestaurantPassword());
			ps.setInt(9,restaurantVO.getrestaurantNo());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer restaurantNo) {
		String delete = "delete from restaurant where restaurantNo = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(delete)){
			
			ps.setInt(1,restaurantNo);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public RestaurantVO findByPrimaryKey(Integer restaurantNo) {
		String findByPrimaryKey = "select * from restaurant where restaurantNo = ?";
		
		RestaurantVO vo = null;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(findByPrimaryKey);
			ResultSet rs = ps.executeQuery()){
			
			ps.setInt(1,restaurantNo);
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
//				Connection con = getConnection();
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(getAll);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				RestaurantVO vo = new RestaurantVO();
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
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		RestaurantDaoImpl test = new RestaurantDaoImpl();
		List<RestaurantVO> list =  test.getAll();
		for (RestaurantVO vo : list) {
			System.out.print(vo.getrestaurantNo() + " , ");
			System.out.print(vo.getrestaurantTel() + " , ");
			System.out.print(vo.getrestaurantName() + " , ");
			System.out.print(vo.getrestaurantTaxIDNo() + " , ");
			System.out.print(vo.getrestaurantAccountInfo() + " , ");
			System.out.print(vo.getrestaurantBusinessHour() + " , ");
			System.out.print(vo.getrestaurantAddr() + " , ");
			System.out.print(vo.getrestaurantStatus() + " , ");
			System.out.print(vo.getrestaurantAccount() + " , ");
			System.out.print(vo.getrestaurantPassword() + " , ");
			System.out.print(vo.getrestaurantCommentQuantity() + " , ");
			System.out.println(vo.getTotalCommentRating());
		}
		
	}
}