package com.tibame.tga104.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.product.dao.ProdPicDAO;
import com.tibame.tga104.product.vo.ProdPicVO;

@Service
public class ProdPicService {
	@Autowired
	private ProdPicDAO dao;
	
	@Transactional
	public ProdPicVO addProdPic(Integer prodNo, byte[] pic, String prodPicRemark) {
		ProdPicVO prodPicVO = new ProdPicVO();
		prodPicVO.setProdNo(prodNo);
		prodPicVO.setProdPic(pic);
		prodPicVO.setProdPicRemark(prodPicRemark);
		
		return dao.insert(prodPicVO);
	}
	
	@Transactional
	public ProdPicVO updateProdPic(Integer prodPicNo, Integer prodNo, byte[] pic, String prodPicRemark) {
		ProdPicVO prodPicVO = new ProdPicVO();
		prodPicVO.setProdPicNo(prodPicNo);
		prodPicVO.setProdNo(prodNo);
		prodPicVO.setProdPic(pic);
		prodPicVO.setProdPicRemark(prodPicRemark);
		
		return dao.update(prodPicVO);
	}
	
	@Transactional
	public boolean deleteProdPic(Integer prodPicNo) {
		return dao.delete(prodPicNo);
	}
	
	public ProdPicVO getOneProdPic(Integer prodPicNo) {
		return dao.findByPrimaryKey(prodPicNo);
	}
	
	public List<ProdPicVO> getAll() {
		return dao.getAll();
	}
	
	public List<ProdPicVO> findByProdNo(Integer prodNo) {
		return dao.findByProdNo(prodNo);
	}
	
	public List<Integer> getPicNoByProdNo(Integer prodNo) {
		return dao.getPicNoByProdNo(prodNo);
	}
}
