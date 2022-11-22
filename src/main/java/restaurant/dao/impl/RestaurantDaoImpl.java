package restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import restaurant.dao.RestaurantDao;
import restaurant.vo.RestaurantVO;

public class RestaurantDaoImpl implements RestaurantDao {
	private DataSource ds;
	
	public RestaurantDaoImpl() throws NamingException {
		ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
	}

	@Override
	public void insert(RestaurantVO restaurantVO) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(RestaurantVO restaurantVO) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Integer restaurantNo) {
		// TODO Auto-generated method stub
	}

	@Override
	public RestaurantVO findByPrimaryKey(Integer restaurantNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantVO> getAll() {
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from restaurant");
			ResultSet rs = pstmt.executeQuery()
		) {
			List<RestaurantVO> list = new ArrayList<>();
			while (rs.next()) {
				RestaurantVO vo = new RestaurantVO();
				vo.setrestaurantNo(rs.getInt(1));
				vo.setrestaurantTel(rs.getString(2));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}