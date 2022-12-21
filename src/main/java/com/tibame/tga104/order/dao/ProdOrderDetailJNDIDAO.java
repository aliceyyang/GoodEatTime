package com.tibame.tga104.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;

public class ProdOrderDetailJNDIDAO{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/goodeattime_test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(ProdOrderDetailVO prodOrderDetailVO) {
		
		String sql_insert = "insert into prodOrderDetail (prodOrderNo, prodNo, prodQty, prodPrice, prodCommentRating, prodCommentContent, prodCommentPic, prodCommentTime, restaurantReplyTime) "
				+ "values (?,?,?,?,?,?,?,?) ";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql_insert)){

			ps.setInt(1, prodOrderDetailVO.getProdOrderNo());
			ps.setInt(2, prodOrderDetailVO.getProdNo());
			ps.setInt(3, prodOrderDetailVO.getProdQty());
//			ps.setInt(4, prodOrderDetailVO.getProdPrice());
			ps.setInt(5, prodOrderDetailVO.getProdCommentRating());
			ps.setString(6, prodOrderDetailVO.getProdCommentContent());
			ps.setBytes(7, prodOrderDetailVO.getProdCommentPic());
			ps.setTimestamp(8, prodOrderDetailVO.getProdCommentTime());
			ps.setTimestamp(9, prodOrderDetailVO.getRestaurantReplyTime());			
			System.out.println("成功筆數為：" + ps.executeUpdate());
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void delete(Integer prodOrderNo) {
		
		String sql_delete = "delete from prodOrderDetail "
				+ "where "
				+ "	prodOrderNo = ? ";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql_delete)){
			
			ps.setInt(1, prodOrderNo);
			System.out.println("成功筆數為：" + ps.executeUpdate());					
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void update(ProdOrderDetailVO prodOrderDetailVO) {
		
		String sql_update = "update prodOrderDetail "
				+ "set "
				+ " prodNo = ?,"
				+ "	prodQty = ?,"
				+ "	prodPrice = ?,"
				+ "	prodCommentRating = ?,"
				+ "	prodCommentContent = ?,"
				+ "	prodCommentPic = ?,"
				+ "	prodCommentTime = ?,"
				+ "	restaurantReplyTime = ?,"
				+ "where "
				+ "	prodOrderNo = ? ";
		
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql_update)){
			
			ps.setInt(1, prodOrderDetailVO.getProdNo());
			ps.setInt(2, prodOrderDetailVO.getProdQty());
//			ps.setInt(3, prodOrderDetailVO.getProdPrice());
			ps.setInt(4, prodOrderDetailVO.getProdCommentRating());
			ps.setString(5, prodOrderDetailVO.getProdCommentContent());
			ps.setBytes(6, prodOrderDetailVO.getProdCommentPic());
			ps.setTimestamp(7, prodOrderDetailVO.getProdCommentTime());
			ps.setTimestamp(8, prodOrderDetailVO.getRestaurantReplyTime());	
			ps.setInt(9, prodOrderDetailVO.getProdOrderNo());
			System.out.println("成功筆數為：" + ps.executeUpdate());
						
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public ProdOrderDetailVO select(Integer prodOrderNo) {
		
		String sql_select = "select prodOrderDetail "
				+ " prodOrderNo, "
				+ " prodNo, "
				+ "	prodQty, "
				+ "	prodPrice, "
				+ "	prodCommentRating, "
				+ "	prodCommentContent, "
				+ "	prodCommentPic, "
				+ "	prodCommentTime, "
				+ "	restaurantReplyTime, "
				+ "from "
				+ "	prodOrderDetail "
				+ "where "
				+ "	prodOrderNo = ? ";

		ProdOrderDetailVO prodOrderDetailVO_select = new ProdOrderDetailVO();
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql_select, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY)){
			
			ps.setInt(1, prodOrderNo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {			
				prodOrderDetailVO_select.setProdOrderNo(rs.getInt("prodOrderNo"));
				prodOrderDetailVO_select.setProdNo(rs.getInt("prodNo"));
				prodOrderDetailVO_select.setProdQty(rs.getInt("prodQty"));
//				prodOrderDetailVO_select.setProdPrice(rs.getInt("prodPrice"));
				prodOrderDetailVO_select.setProdCommentRating(rs.getInt("prodCommentRating"));
				prodOrderDetailVO_select.setProdCommentContent(rs.getString("prodCommentContent"));
				prodOrderDetailVO_select.setProdCommentPic(rs.getBytes("prodCommentPic"));
				prodOrderDetailVO_select.setProdCommentTime(rs.getTimestamp("prodCommentTime"));
				prodOrderDetailVO_select.setRestaurantReplyTime(rs.getTimestamp("restaurantReplyTime"));				
			}	
			
			rs.last();
			System.out.println("成功筆數為：" + rs.getRow());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return prodOrderDetailVO_select;
	}
	public List<ProdOrderDetailVO> getAll(){
		
		String sql_getAll = "select prodOrderDetail "
				+ " prodOrderNo, "
				+ " prodNo, "
				+ "	prodQty, "
				+ "	prodPrice, "
				+ "	prodCommentRating, "
				+ "	prodCommentContent, "
				+ "	prodCommentPic, "
				+ "	prodCommentTime, "
				+ "	restaurantReplyTime, "
				+ "from "
				+ "	prodOrderDetail "
				+ "order by "
				+ "	prodOrderNo ";
		
		List <ProdOrderDetailVO> ProdOrderDetailVO_list = new ArrayList<>();
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql_getAll, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY)){
			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				ProdOrderDetailVO ProdOrderDetailVO_getAll = new ProdOrderDetailVO();
				ProdOrderDetailVO_getAll.setProdOrderNo(rs.getInt("prodOrderNo"));
				ProdOrderDetailVO_getAll.setProdNo(rs.getInt("prodNo"));
				ProdOrderDetailVO_getAll.setProdQty(rs.getInt("prodQty"));
//				ProdOrderDetailVO_getAll.setProdPrice(rs.getInt("prodPrice"));
				ProdOrderDetailVO_getAll.setProdCommentRating(rs.getInt("prodCommentRating"));
				ProdOrderDetailVO_getAll.setProdCommentContent(rs.getString("prodCommentContent"));
				ProdOrderDetailVO_getAll.setProdCommentPic(rs.getBytes("prodCommentPic"));
				ProdOrderDetailVO_getAll.setProdCommentTime(rs.getTimestamp("prodCommentTime"));
				ProdOrderDetailVO_getAll.setRestaurantReplyTime(rs.getTimestamp("restaurantReplyTime"));
				ProdOrderDetailVO_list.add(ProdOrderDetailVO_getAll);
			}
			
			rs.last();
			System.out.println("成功筆數為：" + rs.getRow());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ProdOrderDetailVO_list;
	}

}
