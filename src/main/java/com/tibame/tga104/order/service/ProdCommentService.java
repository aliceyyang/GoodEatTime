package com.tibame.tga104.order.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.tibame.tga104.order.dao.ProdCommentDAO_Hibernate;
import com.tibame.tga104.order.dao.ProdCommentReply_Hibernate;
import com.tibame.tga104.order.vo.ProdCommentReplyVO;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@Service
@Transactional
public class ProdCommentService {
	
	@Autowired
	private ProdCommentDAO_Hibernate dao;
	
	@Autowired
	private ProdCommentReply_Hibernate dao_H;
	
		
	public List<ProdCommentReplyVO> selectNotNullComment(ProdCommentReplyVO prodCommentReplyVO) {
		return dao_H.getNotNullComment(prodCommentReplyVO);
	}
	
	public List<ProdCommentReplyVO> selectNullComment() {
		return dao_H.getNullComment();
	}
	
	public List<ProdCommentReplyVO> selectForMemberNotNullComment(ProdCommentReplyVO prodCommentReplyVO) {
		return dao_H.getForMemberNotNullComment(prodCommentReplyVO);
	}
	
	public List<ProdCommentReplyVO> selectForMemberNullComment(ProdCommentReplyVO prodCommentReplyVO) {
		return dao_H.getForMemberNullComment(prodCommentReplyVO);
	}
	
	public ProdOrderDetailVO updateProdCommnet(ProdOrderDetailVO prodOrderDetailVO) {
		if (prodOrderDetailVO.getProdCommentPic() == null && prodOrderDetailVO.getProdCommentPicStr() != null) {
			prodOrderDetailVO.setProdCommentPic(Base64.getDecoder().decode(prodOrderDetailVO.getProdCommentPicStr()));
		}
		return dao.updateCommnet(prodOrderDetailVO);
	}
	
	public ProdOrderDetailVO replyProdComment(ProdOrderDetailVO prodOrderDetailVO) {
		return dao.replyComment(prodOrderDetailVO);
	}

}
