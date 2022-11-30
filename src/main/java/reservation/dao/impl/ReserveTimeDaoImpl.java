package reservation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import reservation.dao.ReserveTimeDao;
import reservation.vo.ReserveTimeVO;

public class ReserveTimeDaoImpl implements ReserveTimeDao {
	private DataSource dataSource;
	
	public ReserveTimeDaoImpl() throws NamingException {
		 dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
	}
	
	@Override
	public int insert(ReserveTimeVO reserveTimeVo) {
		String sql = "insert into reserveTime (restaurantNo, reserveTime, weekDay, allowReserveNum) "
				+ "values(?, ?, ?, ?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, reserveTimeVo.getRestaurantNo());
			ps.setString(2, reserveTimeVo.getReserveTime());
			ps.setInt(3, reserveTimeVo.getWeekDay());
			ps.setInt(4, reserveTimeVo.getAllowReserveNum());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void updateAllowReserveNum(ReserveTimeVO reserveTimeVo) {
		String sql = "update reserveTime " + "set allowReserveNum = ? " + "where restaurantNO =? and reserveTime = ? and weekDay =?;";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, reserveTimeVo.getAllowReserveNum());
			ps.setInt(2, reserveTimeVo.getRestaurantNo());
			ps.setString(3, reserveTimeVo.getReserveTime());
			ps.setInt(4, reserveTimeVo.getWeekDay());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWeekDay(ReserveTimeVO reserveTimeVO) {
		String sql = "update reserveTime " + "set weekDay = ? " + "where restaurantNO = ?;";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, reserveTimeVO.getWeekDay());
			ps.setInt(2, reserveTimeVO.getRestaurantNo());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ReserveTimeVO findbyrestaurantNOandWeekDay(Integer restaurantNO, Integer weekDay) {
		String sql = "select * from reserveTime where restaurantNO = ? and weekDay = ?;";
		ReserveTimeVO reserveTimeVO = new ReserveTimeVO();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, restaurantNO);
			ps.setInt(2, weekDay);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reserveTimeVO = new ReserveTimeVO();
				
				reserveTimeVO.setReserveTimeNo(rs.getInt("reserveTimeNo"));
				reserveTimeVO.setRestaurantNo(rs.getInt("restaurantNo"));
				reserveTimeVO.setReserveTime(rs.getString("reserveTime"));
				reserveTimeVO.setWeekDay(rs.getInt("weekDay"));
				reserveTimeVO.setAllowReserveNum(rs.getInt("allowReserveNum"));
//				return reserveTimeVO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserveTimeVO;
	}

	@Override
	public List<ReserveTimeVO> getAll() {
		String sql = "SELECT *  FROM reserveTime";
		ReserveTimeVO reserveTimeVO = new ReserveTimeVO();
		List<ReserveTimeVO> list = new ArrayList<ReserveTimeVO>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reserveTimeVO = new ReserveTimeVO();

				reserveTimeVO.setReserveTimeNo(rs.getInt("reserveTimeNo"));
				reserveTimeVO.setRestaurantNo(rs.getInt("restaurantNo"));
				reserveTimeVO.setReserveTime(rs.getString("reserveTime"));
				reserveTimeVO.setWeekDay(rs.getInt("weekDay"));
				reserveTimeVO.setAllowReserveNum(rs.getInt("allowReserveNum"));

				list.add(reserveTimeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
