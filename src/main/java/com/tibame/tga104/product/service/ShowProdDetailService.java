package com.tibame.tga104.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.product.dao.ShowProdDetailDAO;
import com.tibame.tga104.product.vo.ShowProdDetailVO;

@Service
public class ShowProdDetailService {
	@Autowired
	private ShowProdDetailDAO dao;

	public ShowProdDetailVO select(Integer prodNo) {
		return dao.select(prodNo);
	}
}
