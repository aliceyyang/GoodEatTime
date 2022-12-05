package reservation.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import member.vo.Member;
import reservation.dao.impl.ReservationDaoImpl;
import reservation.service.ReservationService;
import reservation.vo.ReservationVO;
import restaurant.vo.RestaurantVO;

public class ReservationServiceImpl implements ReservationService{

	private ReservationDaoImpl dao;
	@Override
	public ReservationVO BookTable(ReservationVO reservationVO) {
		ReservationVO result = null;
		if (new RestaurantVO().getrestaurantNo() != null && new Member().getMemberNo() != null) {
			result = dao.insert(reservationVO);
		}
		return result;
	}

	@Override
	public boolean CommentRestaurant(Integer reserveNo, Integer memberNo, Integer commentRating, String commentContent,
			byte[] commentPic, Timestamp restaurantCommentTime) {
		
		return false;
	}

	@Override
	public boolean RestaurantReply(Integer reserveNo, Integer commentRating, String restaurantRe,
			Timestamp restaurantReTime) {
		return false;
	}

	@Override
	public ReservationVO findByDate(Integer reserveDate) {
		return dao.findByPrimaryKey(reserveDate);
	}

	@Override
	public List<ReservationVO> getAll() {
		return dao.getAll();
	}

}
