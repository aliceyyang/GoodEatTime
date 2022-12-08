package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ProdCategoryVO;

public interface ProdCategoryDAO {
	
	public ProdCategoryVO insert(ProdCategoryVO prodCategory);
	public boolean update(ProdCategoryVO prodCategory);
	public boolean delete(Integer prodCategoryNo);
	public ProdCategoryVO findByPrimaryKey(Integer prodCategoryNo);
	public List<ProdCategoryVO> getAll();
	
}
