package com.tibame.tga104.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.OrderSearchService;
import com.tibame.tga104.order.vo.OrderSearchVO;

@RestController
@RequestMapping("v_OrderSearch")
public class OrderSearchController {
	
	@Autowired
	private OrderSearchService orderSearchService;
	
	@PostMapping("searchByConditions")
	public List<OrderSearchVO> selectProdOrder(@RequestBody(required = false) OrderSearchVO orderSearchVO) {
		return orderSearchService.findByConditions(orderSearchVO);
	}
}
