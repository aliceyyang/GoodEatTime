package com.tibame.tga104.restaurant.dao.impl;

import static com.tibame.tga104.common.util.JdbcUtil.PASSWORD;
import static com.tibame.tga104.common.util.JdbcUtil.URL;
import static com.tibame.tga104.common.util.JdbcUtil.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.ReservationCommentDAO;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;
import com.tibame.tga104.restaurant.vo.ReservationCommentVO;

@Repository
public class ReservationCommentDAOImpl implements ReservationCommentDAO {

	@Override
	public List<Integer> getAllRating(Integer restaurantNo) {
		String getAllRating = "select count(*) from reservation " + "where restaurantNo = ? "
				+ "group by commentRating " + "order by commentRating desc";
		List<Integer> allRating = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(getAllRating);) {
			ps.setInt(1, restaurantNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allRating.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRating;
	}

	@Override
	public List<ReservationCommentVO> findByRestaurantNo(Integer restaurantNo) {
		String findByRestaurantNo = "select "
				+ "r.reserveNo,m.name,m.memberPic,r.commentRating,r.commentContent, "
				+ "r.commentPic,r.restaurantCommentTime,r.restaurantRe,r.restaurantReTime "
				+ "from member m "
				+ "join reservation r "
				+ "on m.memberNo = r.memberNo "
				+ "where restaurantNo = ? "
				+ "and commentRating is not null "
				+ "order by restaurantCommentTime desc";
		
		List<ReservationCommentVO> allComment = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(findByRestaurantNo);) {
			ps.setInt(1, restaurantNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReservationCommentVO vo = new ReservationCommentVO();
				vo.setReserveNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setMemberPic(rs.getBytes(3));
				vo.setCommentRating(rs.getInt(4));
				vo.setCommentContent(rs.getString(5));
				vo.setCommentPic(rs.getBytes(6));
				vo.setRestaurantCommentTime(rs.getTimestamp(7));
				vo.setRestaurantRe(rs.getString(8));
				vo.setRestaurantReTime(rs.getTimestamp(9));
				
				allComment.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allComment;
	}

}
