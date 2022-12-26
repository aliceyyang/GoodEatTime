package com.tibame.tga104.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.ProdCommentDAO_Hibernate;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@Service
@Transactional
public class ProdCommentService {
	
	@Autowired
	private ProdCommentDAO_Hibernate dao;
	
		
	public List<ProdOrderDetailVO> selectNotNullComment() {
		return dao.getNotNullComment();
	}
	
	public List<ProdOrderDetailVO> selectNullComment() {
		return dao.getNullComment();
	}
	
	public ProdOrderDetailVO updateProdCommnet(ProdOrderDetailVO prodOrderDetailVO) {
		return dao.updateCommnet(prodOrderDetailVO);
	}
	
	public ProdOrderDetailVO replyProdComment(ProdOrderDetailVO prodOrderDetailVO) {
		return dao.replyComment(prodOrderDetailVO);
	}

}
