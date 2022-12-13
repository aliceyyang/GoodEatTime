package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ProdInfoVO;

public interface ProdInfoDAO {
	public ProdInfoVO insert(ProdInfoVO prodInfoVO);
	public ProdInfoVO update(ProdInfoVO prodInfoVO);
	public boolean delete(Integer prodNo);
	public ProdInfoVO findByPrimaryKey(Integer prodNo);
	public List<ProdInfoVO> getAll();
	public List<ProdInfoVO> findByProdCategory(Integer ProdCategoryNo);
}
