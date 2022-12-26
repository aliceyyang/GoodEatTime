package com.tibame.tga104.reservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	private ReserveTimeService reserveTimeService;

	@Autowired
	private ReservationService reservationService;

	// 餐廳設定訂位人數 這是對的唷ok
//	@PostMapping("restaurant")
//	public Map<String, Object> restaurant(HttpSession httpSession, @RequestBody List<ReserveTimeVO> reserveTimeList) {
//		RestaurantMemberVO vo = (RestaurantMemberVO)httpSession.getAttribute("restaurantMemberVO");
//		Integer restaurantNo = vo.getRestaurantNo();
//		boolean result = reserveTimeService.setReserveTime(restaurantNo, reserveTimeList);
//		Map<String, Object> resMap = new HashMap<String, Object>();
//		resMap.put("sucessful", result);
//		return resMap;
//	}
	// 先寫死測試用
	@PostMapping("restaurant")
	public Map<String, Object> restaurant(@RequestBody List<ReserveTimeVO> reserveTimeList) {
		boolean result = reserveTimeService.setReserveTime(2, reserveTimeList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("sucessful", result);
		return resMap;
	}
//----------------------------------------------------

	// 這是對的唷 餐廳查找訂位設定ok
//	@GetMapping("restaurant/inf")
//	public List<ReserveTimeVO> table(HttpSession httpSession, @RequestParam Integer weekDay) {
//		RestaurantMemberVO restaurantMemberVO =(RestaurantMemberVO)httpSession.getAttribute("restaurantMemberVO");
//		return reserveTimeService.findByWeekDay(restaurantMemberVO.getRestaurantNo(), weekDay);
//	}

	// 這是測試用
	@GetMapping("restaurant/inf")
	public List<ReserveTimeVO> table(@RequestParam Integer weekDay) {
		return reserveTimeService.findByWeekDay(2, weekDay);
	}

	// -----------------------------------------

	@GetMapping("member/inf")
	public List<MemberReserveInfVO> memberReserveInf() {
		// TODO 5是暫時寫死的唷!!!
		return reservationService.findByMemberNO(5);
	}

	// 會員專區訂位資訊ok
//	@GetMapping("member/inf")
//	public List<MemberReserveInfVO> memberReserveInf(HttpSession session) {
//		MemberVO vo = (MemberVO) session.getAttribute("memberVO");
//		Integer member = vo.getMemberNo();
//		return reservationService.findByMemberNO(member);
//	}
// ----------------------------------------------------------------	
	// 這是對的唷ok
//	@GetMapping("restaurant/reserveStatus")
//	public List<ReservationDetailVO> reserveStatus(HttpSession httpSession, @RequestParam java.sql.Date date) {
//		RestaurantMemberVO restaurantMemberVO =(RestaurantMemberVO)httpSession.getAttribute("restaurantMemberVO");
//		return reservationService.findByRestaurantNoAndDate(restaurantMemberVO.getRestaurantNo(), date);
//	}

	@GetMapping("restaurant/reserveStatus")
	public List<ReservationDetailVO> reserveStatus(@RequestParam java.sql.Date date) {
		return reservationService.findByRestaurantNoAndDate(1, date);
	}

// --------------------------------

	// 餐廳查找消費者訂位資訊 這是對的唷ok
//	@GetMapping("restaurant/reserveInf")
//	public Map<String, Object> reserveInf(HttpSession httpSession, @RequestParam java.sql.Date date) {
//		RestaurantVO vo = (RestaurantVO)httpSession.getAttribute("restaurantMemberVO");
//		Integer restaurantNo = vo.getRestaurantNo();
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("data", reservationService.findByReserveDate(restaurantNo, date));
//		return resultMap;
//	}

	@GetMapping("restaurant/reserveInf")
	public Map<String, Object> reserveInf(@RequestParam java.sql.Date date) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", reservationService.findByReserveDate(1, date));
		return resultMap;
	}

	// ----------------------------------
	// 修改訂位狀態ok
//	@GetMapping("restaurant/statusUpdate")
//	public boolean reseveStatus(@RequestParam Integer reserveNo, @RequestParam String reserveStatus,
//			HttpSession session) {
//		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
//		if (restaurantMemberVO.getRestaurantNo() != null) {
//			return reservationService.changeStatus(reserveNo, reserveStatus);
//		}
//		return false;
//	}

	@GetMapping("restaurant/statusUpdate")
	public boolean reseveStatus(@RequestParam Integer reserveNo, @RequestParam String reserveStatus) {
		return reservationService.changeStatus(reserveNo, reserveStatus);
	}

	// 消費者訂位ok
//	@PostMapping("member")
//	public boolean member(@RequestBody ReservationVO vo, HttpSession httpSession) {
//		MemberVO memberVO = (MemberVO)httpSession.getAttribute("memberVO");
//		Integer member = memberVO.getMemberNo();
//		if(vo != null && member != null) {
//			if (vo.getReserveNum() <= reserveTimeService.getAvailableSeats(vo.getRestaurantNo(), vo.getReserveDate(),
//					vo.getReserveTime())) {
//				return reservationService.reservation(vo);
//			}	
//		}
//		return false;
//	}

	@PostMapping("member")
	public boolean member(@RequestBody ReservationVO vo) {
		if (vo != null && vo.getMemberNo() != null) {
			if (vo.getReserveNum() <= reserveTimeService.getAvailableSeats(vo.getRestaurantNo(), vo.getReserveDate(),
					vo.getReserveTime())) {
				return reservationService.reservation(vo);
			}
		}
		return false;
	}

	// --------------------------查找營業時間 (星期)ok
//	@GetMapping("restaurant/date")
//	public List<Integer> reserveTime(HttpSession session) {
//		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
//		int restaurantNo = restaurantMemberVO.getRestaurantNo();
//		return reserveTimeService.findByRestaurantNo(restaurantNo);
//	}

	// wrong
	@GetMapping("restaurant/date")
	public List<Integer> reserveTime() {
		return reserveTimeService.findByRestaurantNo(2);
	}

	// -----------查找可訂位人數ok
//	@PostMapping("restaurant/seat")
//	public int seats(@RequestBody ReservationVO vo, HttpSession session) {
//		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
//		int restaurantNo = restaurantMemberVO.getRestaurantNo();
//		return reserveTimeService.getAvailableSeats(restaurantNo, vo.getReserveDate(), vo.getReserveTime());
//	}

//	@PostMapping("restaurant/seat")
//	public Integer seats(@RequestBody ReservationVO vo) {
//		return reserveTimeService.getAvailableSeats(2, vo.getReserveDate(), vo.getReserveTime());
//	}

//-----------------更新訂位成功但未報到的資料ok

	@PostMapping("restaurant/statusChange")
	public boolean statusChange(@RequestBody ReservationVO vo) {
		if (vo.getReserveDate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date today = sdf.parse(sdf.format(new java.util.Date()));
				java.util.Date date = sdf.parse(sdf.format(vo.getReserveDate()));
				if (date.before(today)) {
					return reservationService.changeStatus(1, vo.getReserveDate());
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

//	@PostMapping("restaurant/statusChange")
//	public boolean statusChange(@RequestBody ReservationVO vo, HttpSession session) {
//		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO)session.getAttribute("restaurantMemberVO");
//		int restaurantNo = restaurantMemberVO.getRestaurantNo();
//		if(vo.getReserveDate() != null) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				java.util.Date today = sdf.parse(sdf.format(new java.util.Date()));
//				java.util.Date date = sdf.parse(sdf.format(vo.getReserveDate()));
//				if(date.before(today)){
//					return reservationService.changeStatus(restaurantNo, vo.getReserveDate());
//				}
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}

}
