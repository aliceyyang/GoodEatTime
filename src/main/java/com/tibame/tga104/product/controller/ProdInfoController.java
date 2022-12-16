package com.tibame.tga104.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.product.service.ProdCategoryService;
import com.tibame.tga104.product.service.ProdPicService;
import com.tibame.tga104.product.service.ShowProdDetailService;
import com.tibame.tga104.product.service.ShowProdInMallService;
import com.tibame.tga104.product.vo.ShowProdDetailVO;

@RestController
@RequestMapping("product")
public class ProdInfoController {
	@Autowired
	private ShowProdInMallService showProdInMallService;
	@Autowired
	private ShowProdDetailService showProdDetailService;
	@Autowired
	private ProdPicService prodPicService;
	@Autowired
	private ProdCategoryService prodCategoryService;
	
	@GetMapping("all")
	public Map<String, List> showAll() {
		Map<String, List> map = new HashMap<String, List>();
		map.put("prodList", showProdInMallService.getAll());
		map.put("prodCategoryList", prodCategoryService.getAll());
		return map;
	}
	
	@GetMapping("detail")
	public ShowProdDetailVO showOneDetail(@RequestParam Integer prodNo) {
		ShowProdDetailVO vo = showProdDetailService.select(prodNo);
		vo.setProdPicList(prodPicService.getPicNoByProdNo(prodNo));
		return vo;
	}

}
