package reservation.service.impl;

import java.util.List;

import reservation.vo.ReservationVO;

public interface reservationService {
		
	ReservationVO BookTable(Integer reserveNum, Integer memberNo, java.sql.Date reserveDate, String reserveTime, String remark);
	
	boolean CommentRestaurant(Integer reserveNo, Integer memberNo, Integer commentRating, String commentContent, byte[] commentPic, java.sql.Timestamp restaurantCommentTime);
	
	boolean RestaurantReply(Integer reserveNo, String restaurantRe, java.sql.Timestamp restaurantReTime);
	
	ReservationVO findByDate(Integer reserveDate);
	
	List<ReservationVO> getAll();

}
