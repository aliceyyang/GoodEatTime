package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ShowProdInMallVO;

public interface ShowProdInMallDAO {
	public List<ShowProdInMallVO> getAll();
	public List<ShowProdInMallVO> getFromProdCategory(Integer prodCategoryNo);
}
