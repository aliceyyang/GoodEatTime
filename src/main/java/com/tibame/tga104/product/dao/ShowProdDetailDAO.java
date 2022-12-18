package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ShowProdDetailVO;

public interface ShowProdDetailDAO {
	public ShowProdDetailVO select(Integer prodNo);
	public List<ShowProdDetailVO> select6ByCategory(Integer prodCategoryNo);
}
