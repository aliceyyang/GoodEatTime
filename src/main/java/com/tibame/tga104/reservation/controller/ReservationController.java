package com.tibame.tga104.reservation.controller;

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

import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	private ReserveTimeService reserveTimeService;

	@Autowired
	private ReservationService reservationService;

	// 這是對的唷 更新/插入
//	@PostMapping("restaurant")
//	public Map<String, Object> restaurant(HttpSession httpSession, @RequestBody List<ReserveTimeVO> reserveTimeList) {
//		Integer restaurantNo = (Integer) httpSession.getAttribute("restaurantNo");
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

	// 這是對的唷 查找訂位設定
//	@GetMapping("restaurant/inf")
//	public List<ReserveTimeVO> table(HttpSession httpSession, @RequestParam Integer weekDay){
//		return reserveTimeService.findByWeekDay((Integer)httpSession.getAttribute("restaurantNo"), weekDay);
//	}

	// 這是測試用
	@GetMapping("restaurant/inf")
	public List<ReserveTimeVO> table(@RequestParam Integer weekDay) {
		return reserveTimeService.findByWeekDay(2, weekDay);
	}

	// -----------------------------------------

//	@GetMapping("member/inf")
//	public List<MemberReserveInfVO> memberReserveInf() {
//		// TODO 5是暫時寫死的唷!!!
//		return reservationService.findByMemberNO(5);
//	}

	@GetMapping("member/inf")
	public List<MemberReserveInfVO> memberReserveInf(HttpSession session) {
		Integer member = (Integer) session.getAttribute("memberNo");
		return reservationService.findByMemberNO(member);
	}
// ----------------------------------------------------------------	
	// 這是對的唷
//		@GetMapping("restaurant/reserveStatus")
//		public List<ReservationDetailVO> reserveStatus(HttpSession httpSession, @RequestParam java.sql.Date date){
//			return reservationService.findByRestaurantNoAndDate((Integer)httpSession.getAttribute("restaurantNo"), date);
//		}

	@GetMapping("restaurant/reserveStatus")
	public List<ReservationDetailVO> reserveStatus(@RequestParam java.sql.Date date) {
		return reservationService.findByRestaurantNoAndDate(1, date);
	}

// --------------------------------

	// 這是對的唷
//	@GetMapping("restaurant/reserveInf")
//	public Map<String, Object> reserveInf(HttpSession httpSession, @RequestParam java.sql.Date date) {
//		Integer restaurantNo = (Integer) httpSession.getAttribute("restaurantNo");
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
	
	//----------------------------------
	@PostMapping("restaurant/statusUpdate")
	public boolean reseveStatus(@RequestBody ReservationVO vo) {
		return reservationService.changeStatus(vo);
	}
	
	
	
	
}
