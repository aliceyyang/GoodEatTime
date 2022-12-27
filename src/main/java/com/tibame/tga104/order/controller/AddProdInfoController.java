package com.tibame.tga104.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.AddProdInfoService;
import com.tibame.tga104.product.vo.ProdInfoVO;

@RestController
@RequestMapping("addProdInfo")
public class AddProdInfoController {
	
	@Autowired
	private AddProdInfoService addProdInfoService;
	
	@PostMapping("prodInfoUpdate")
	public ProdInfoVO prodInfoUpdate(@RequestBody(required = false) ProdInfoVO prodInfoVO) {
		return addProdInfoService.updateProdInfo(prodInfoVO);
	}

}
