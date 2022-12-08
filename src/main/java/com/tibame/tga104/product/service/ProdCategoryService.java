package com.tibame.tga104.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.product.dao.ProdCategoryDAO;
import com.tibame.tga104.product.vo.ProdCategoryVO;

@Service
public class ProdCategoryService {
	@Autowired
	private ProdCategoryDAO dao;
	
	
	@Transactional
	public ProdCategoryVO addProdCategory(String prodCategory) {
		ProdCategoryVO myProdCategory = new ProdCategoryVO();
		myProdCategory.setProdCategory(prodCategory);
		dao.insert(myProdCategory);
		
		return myProdCategory;
	}
	
	@Transactional
	public ProdCategoryVO updateProdCategory(Integer prodCategoryNo, String prodCategory) {
		ProdCategoryVO myProdCategory = new ProdCategoryVO();
		myProdCategory.setProdCategoryNo(prodCategoryNo);
		myProdCategory.setProdCategory(prodCategory);
		dao.update(myProdCategory);
		
		return myProdCategory;
	}
	
	@Transactional
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
