package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;

public interface ProdCommentDAO_interface {

	List<ProdOrderDetailVO> getNotNullComment();
	
	List<ProdOrderDetailVO> getNullComment();
	
	ProdOrderDetailVO updateCommnet(ProdOrderDetailVO prodOrderDetailVO);
	
	ProdOrderDetailVO replyComment(ProdOrderDetailVO prodOrderDetailVO);

}