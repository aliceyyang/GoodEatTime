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

	// 餐廳設定訂位人數
	@PostMapping("restaurant")
	public Map<String, Object> restaurant(HttpSession httpSession, @RequestBody List<ReserveTimeVO> reserveTimeList) {
		RestaurantMemberVO vo = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		Integer restaurantNo = vo.getRestaurantNo();
		boolean result = reserveTimeService.setReserveTime(restaurantNo, reserveTimeList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("sucessful", result);
		return resMap;
	}

	// 餐廳更新訂位成功但未報到
	@PostMapping("restaurant/statusChange")
	public boolean statusChange(@RequestBody ReservationVO vo, HttpSession session) {
		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
		int restaurantNo = restaurantMemberVO.getRestaurantNo();
		if (vo.getReserveDate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date today = sdf.parse(sdf.format(new java.util.Date()));
				java.util.Date date = sdf.parse(sdf.format(vo.getReserveDate()));
				if (date.before(today)) {
					return reservationService.changeStatus(restaurantNo, vo.getReserveDate());
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// 餐廳查找訂位設定
	@GetMapping("restaurant/inf")
	public List<ReserveTimeVO> table(HttpSession httpSession, @RequestParam Integer weekDay) {
		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		return reserveTimeService.findByWeekDay(restaurantMemberVO.getRestaurantNo(), weekDay);
	}

	// 餐廳從日期查看訂位人數
	@GetMapping("restaurant/reserveStatus")
	public List<ReservationDetailVO> reserveStatus(HttpSession httpSession, @RequestParam java.sql.Date date) {
		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		return reservationService.findByRestaurantNoAndDate(restaurantMemberVO.getRestaurantNo(), date);
	}

	// 餐廳查找詳細消費者訂位資訊
	@GetMapping("restaurant/reserveInf")
	public Map<String, Object> reserveInf(HttpSession httpSession, @RequestParam java.sql.Date date) {
		RestaurantMemberVO vo = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
		Integer restaurantNo = vo.getRestaurantNo();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("data", reservationService.findByReserveDate(restaurantNo, date));
		return resultMap;
	}

	// 餐廳修改訂位狀態
	@GetMapping("restaurant/statusUpdate")
	public boolean reseveStatus(@RequestParam Integer reserveNo, @RequestParam String reserveStatus,
			HttpSession session) {
		RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
		if (restaurantMemberVO.getRestaurantNo() != null) {
			return reservationService.changeStatus(reserveNo, reserveStatus);
		}
		return false;
	}
	// -----------------------------------------

	// 會員專區訂位資訊
	@GetMapping("member/inf")
	public List<MemberReserveInfVO> memberReserveInf(HttpSession session) {
		MemberVO vo = (MemberVO) session.getAttribute("memberVO");
		Integer member = vo.getMemberNo();
		return reservationService.findByMemberNO(member);
	}

// ----------------------------------------------------------------	


	// 消費者訂位
	@PostMapping("member")
	public boolean member(@RequestBody ReservationVO vo, HttpSession httpSession) {
		MemberVO memberVO = (MemberVO) httpSession.getAttribute("memberVO");
		Integer member = memberVO.getMemberNo();
		if (vo != null && member != null) {
			if (vo.getReserveNum() <= reserveTimeService.getAvailableSeats(vo.getRestaurantNo(), vo.getReserveDate(),
					vo.getReserveTime())) {
				return reservationService.reservation(vo);
			}
		}
		return false;
	}

	// 查找餐廳營業時間(星期)
	@GetMapping("restaurant/date")
	public List<Integer> reserveTime(@RequestParam Integer restaurantNo) {
		return reserveTimeService.findByRestaurantNo(restaurantNo);
	}

	// -----------查找可訂位人數ok
	@PostMapping("restaurant/seat")
	public int seats(@RequestBody ReservationVO vo) {
		return reserveTimeService.getAvailableSeats(vo.getRestaurantNo(), vo.getReserveDate(), vo.getReserveTime());
	}

}
