package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.ProdCommentReplyVO;

public interface ProdCommentReply_interface {

	List<ProdCommentReplyVO> getNotNullComment(ProdCommentReplyVO prodCommentReplyVO);

	List<ProdCommentReplyVO> getNullComment();

	List<ProdCommentReplyVO> getForMemberNotNullComment(ProdCommentReplyVO prodCommentReplyVO);

	List<ProdCommentReplyVO> getForMemberNullComment(ProdCommentReplyVO prodCommentReplyVO);

}