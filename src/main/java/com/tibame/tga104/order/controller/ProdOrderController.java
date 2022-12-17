package com.tibame.tga104.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.ProdOrderService;
import com.tibame.tga104.order.vo.ProdOrderVO;

@RestController
@RequestMapping("prodOrder")
public class ProdOrderController {
	@Autowired
	private ProdOrderService prodOrderService;
	
	@PostMapping("searchByConditions")
	public List<ProdOrderVO> selectProdOrder(@RequestBody(required = false) ProdOrderVO prodOrderVO) {
		return prodOrderService.findByConditions(prodOrderVO);
	}
}
