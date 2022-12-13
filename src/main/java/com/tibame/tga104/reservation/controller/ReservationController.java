package com.tibame.tga104.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	private ReserveTimeService reserveTimeService;
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("restaurant")
	public Map<String, Object> restaurant(@RequestBody List<ReserveTimeVO> reserveTimeList){
		boolean result = reserveTimeService.setReserveTime(reserveTimeList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("sucessful", result);
		return resMap;
	}
	
	@GetMapping("member/inf")
	public List<MemberReserveInfVO> memberReserveInf() {
		// TODO 5是暫時寫死的唷!!!
		return reservationService.findByMemberNO(5);
	}
}
