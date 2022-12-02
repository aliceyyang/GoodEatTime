package restaurant.dao.impl;

import static common.util.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import restaurant.dao.likedRestaurantDAO;
import restaurant.vo.likedRestaurantVO;

public class likedRestaurantDAOImpl implements likedRestaurantDAO{
	

	@Override
	public void insert(likedRestaurantVO likedRestaurantVO) {
		String insert = "insert into likedRestaurant"
				+ "values(?,?)";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(insert)){
			
			ps.setInt(1,likedRestaurantVO.getMemberNo());
			ps.setInt(2,likedRestaurantVO.getRestaurantNo());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void delete(Integer restaurantNo,Integer memberNo) {
		String delete = "delete from likedRestaurant"
				+ "where memberNo = ? and restaurantNo = ?";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(delete)){
			
			ps.setInt(1,restaurantNo);
			ps.setInt(2,memberNo);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<likedRestaurantVO> findByMemberNo(Integer memberNo) {
		String findByMemberNo = "select * from likedRestaurant"
				+ "where memberNo = ?;";
		
		List<likedRestaurantVO> list = new ArrayList<>();
		
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(findByMemberNo);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				likedRestaurantVO vo = new likedRestaurantVO();
				vo.setMemberNo(rs.getInt(1));
				vo.setRestaurantNo(rs.getInt(2));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
