package com.tibame.tga104.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.product.dao.ShowProdInMallDAO;
import com.tibame.tga104.product.vo.ShowProdInMallVO;

@Service
public class ShowProdInMallService {
	@Autowired
	private ShowProdInMallDAO dao;
	
	public List<ShowProdInMallVO> getAll() {
		return dao.getAll();
	}
	
	public List<ShowProdInMallVO> getFromProdCategory(Integer prodCategoryNo) {
		return dao.getFromProdCategory(prodCategoryNo);
	}
	
	public List<ShowProdInMallVO> select6ByCategory(Integer prodCategoryNo) {
		return dao.select6ByCategory(prodCategoryNo);
	}
	
	public List<ShowProdInMallVO> getFromRestaurant(Integer restaurantNo) {
		return dao.getFromRestaurant(restaurantNo);
	}
}
