package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ShowProdInMallVO;

public interface ShowProdInMallDAO {
	public ShowProdInMallVO select(Integer prodNo);
	public List<ShowProdInMallVO> getAll();
	public List<ShowProdInMallVO> getFromProdCategory(Integer prodCategoryNo);
	public List<ShowProdInMallVO> getFromRestaurant(Integer restaurantNo);
	public List<ShowProdInMallVO> select6ByCategory(Integer prodCategoryNo);
}
