package com.tibame.tga104.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.AddProdInfoDAO_Hibernate;
import com.tibame.tga104.product.vo.ProdInfoVO;

@Service
@Transactional
public class AddProdInfoService {
	
	@Autowired
	private AddProdInfoDAO_Hibernate dao;
	
	public ProdInfoVO updateProdInfo (ProdInfoVO prodInfoVO) {
		return dao.updateProd(prodInfoVO);
	}

	
}
