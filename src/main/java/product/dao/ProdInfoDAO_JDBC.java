package product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import product.vo.ProdInfoVO;

public class ProdInfoDAO_JDBC implements ProdInfoDAO{
	
	private static String URL = "jdbc:mysql://localhost:3306/goodeattime?serverTimezone=Asia/Taipei";
	private static String USER = "root";
	private static String PASSWORD = "password";

	@Override
	public void insert(ProdInfoVO productVO) {
		String insertSQL = "insert into prodInfo "
				+ "(restaurantNo, prodCategoryNo, prodName, prodPrice, prodStock, prodDescription, prodContent)"
				+ "values(?, ?, ?, ?, ?, ?, ?);";
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setInt(1, productVO.getRestaurantNo());
			ps.setInt(2, productVO.getProdCategoryNo());
			ps.setString(3, productVO.getProdName());
			ps.setInt(4, productVO.getProdPrice());
			ps.setInt(5, productVO.getProdStock());
			ps.setString(6, productVO.getProdDescription());
			ps.setString(7, productVO.getProdContent());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(ProdInfoVO productVO) {
		String updateSQL = "update prodInfo set restaurantNo = ?, prodCategoryNo = ?,"
				+ " prodName = ?, prodPrice = ?, prodStock = ?, prodDescription = ?,"
				+ " prodContent = ?, prodCommentQty = ?, totalCommentRating = ? where prodNo = ?;";
		
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setInt(1, productVO.getRestaurantNo());
			ps.setInt(2, productVO.getProdCategoryNo());
			ps.setString(3, productVO.getProdName());
			ps.setInt(4, productVO.getProdPrice());
			ps.setInt(5, productVO.getProdStock());
			ps.setString(6, productVO.getProdDescription());
			ps.setString(7, productVO.getProdContent());
			ps.setInt(8, productVO.getProdCommentQty());
			ps.setInt(9, productVO.getTotalCommentRating());
			ps.setInt(10, productVO.getProdNo());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(Integer prodNo) {
		String deleteSQL = "delete from prodInfo where prodNo = ?";
		int rowCount = 0;
		
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, prodNo);
			rowCount = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount != 0;
	}

	@Override
	public ProdInfoVO findByPrimaryKey(Integer prodNo) {
		ProdInfoVO myProduct = null;
		String findByPRimaryKeySQL = "select * from prodInfo where prodNo = ?";
		
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(findByPRimaryKeySQL)){
			ps.setInt(1, prodNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				myProduct = new ProdInfoVO();
				myProduct.setProdNo(rs.getInt("prodNo"));
				myProduct.setRestaurantNo(rs.getInt("RestaurantNo"));
				myProduct.setProdCategoryNo(rs.getInt("prodCategoryNo"));
				myProduct.setProdName(rs.getString("prodName"));
				myProduct.setProdPrice(rs.getInt("prodPrice"));
				myProduct.setProdStock(rs.getInt("prodStock"));
				myProduct.setProdContent(rs.getString("prodContent"));
				myProduct.setProdDescription(rs.getString("prodDescription"));
				myProduct.setProdCommentQty(rs.getInt("prodCommentQty"));
				myProduct.setTotalCommentRating(rs.getInt("totalCommentRating"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return myProduct;
	}

	@Override
	public List<ProdInfoVO> getAll() {
		String getAllSQL = "select * from prodInfo;";
		
		List<ProdInfoVO> list = new ArrayList<>();
		ProdInfoVO myProduct = null;
		
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(getAllSQL)){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				myProduct = new ProdInfoVO();
				myProduct.setProdNo(rs.getInt("prodNo"));
				myProduct.setRestaurantNo(rs.getInt("restaurantNo"));
				myProduct.setProdCategoryNo(rs.getInt("prodCategoryNo"));
				myProduct.setProdName(rs.getString("prodName"));
				myProduct.setProdPrice(rs.getInt("prodPrice"));
				myProduct.setProdStock(rs.getInt("prodStock"));
				myProduct.setProdDescription(rs.getString("prodDescription"));
				myProduct.setProdContent(rs.getString("prodContent"));
				myProduct.setProdCommentQty(rs.getInt("prodCommentQty"));
				myProduct.setTotalCommentRating(rs.getInt("totalCommentRating"));
				list.add(myProduct);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
