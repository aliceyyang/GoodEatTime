package com.tibame.tga104.product.service;

import java.util.List;

import com.tibame.tga104.product.dao.ProdCategoryDAO;
import com.tibame.tga104.product.dao.ProdCategoryDAO_JNDI;
import com.tibame.tga104.product.vo.ProdCategoryVO;

public class ProdCategoryService {
	private ProdCategoryDAO dao;
	
	public ProdCategoryService() {
		dao = new ProdCategoryDAO_JNDI();
	}
	
	public ProdCategoryVO addProdCategory(String prodCategory) {
		ProdCategoryVO newProdCategory = new ProdCategoryVO();
		newProdCategory.setProdCategory(prodCategory);
		dao.insert(newProdCategory);
		
		return newProdCategory;
	}
	
	public ProdCategoryVO updateProdCategory(Integer prodCategoryNo, String prodCategory) {
		ProdCategoryVO myProdCategory = new ProdCategoryVO();
		myProdCategory.setProdCategoryNo(prodCategoryNo);
		myProdCategory.setProdCategory(prodCategory);
		dao.update(myProdCategory);
		
		return myProdCategory;
	}
	
	public boolean deleteProdCategory(Integer prodCategoryNo) {
		return dao.delete(prodCategoryNo);
	}
	
	public ProdCategoryVO getOneProdCategory(Integer prodCategoryNo) {
		return dao.findByPrimaryKey(prodCategoryNo);
	}
	
	public List<ProdCategoryVO> getAll() {
		return dao.getAll();
	}
}
