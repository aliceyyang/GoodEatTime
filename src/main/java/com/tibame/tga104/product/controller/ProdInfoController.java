package com.tibame.tga104.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.product.service.ShowProdInMallService;
import com.tibame.tga104.product.vo.ShowProdInMallVO;

@RestController
@RequestMapping("product")
public class ProdInfoController {
	@Autowired
	private ShowProdInMallService showProdInMallService;
	
	@GetMapping("all")
	public List<ShowProdInMallVO> showAll() {
		return showProdInMallService.getAll();
	}

}
