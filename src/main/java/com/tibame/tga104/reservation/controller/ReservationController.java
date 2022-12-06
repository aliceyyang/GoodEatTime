package com.tibame.tga104.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	private ReserveTimeService service;
	
	@PostMapping("restaurant")
	public Map<String, Object> restaurant(@RequestBody List<ReserveTimeVO> reserveTimeList){
		boolean result = service.setReserveTime(reserveTimeList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("sucessful", result);
		return resMap;
	}
}
